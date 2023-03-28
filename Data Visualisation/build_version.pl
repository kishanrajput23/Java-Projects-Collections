$major = 0;
$minor = 0;
$subminor = 1;
foreach(@ARGV){
	print $_."\n";
	if(index($_,"-minor")!=-1){
		$minor = 1;
		$subminor = 0;
	}elsif(index($_,"-major")!=-1){
		$major = 1;
	}
}
$date = `date +%F`;
$hash = `git log --format="%H" -n 1`;
$username = `git log --format="%cn" -n 1`;
$message = `git log --format="%s" -n 1`;
$hash = substr($hash,0,7);

chomp($username);
chomp($message);
chomp($date);

#print $date."_".$hash."\n";
print $date ." ".$hash." ".$username." ".$message." \n"; 

open($original_pom, "pom.xml");
open($new_pom, ">pom_new.xml");
open($build_history, ">>build_history.txt");

while(<$original_pom>){
	chomp;
	#print $_ ."\n";
	if(index($_, "<version>")!=-1&&index($_, "SNAPSHOT")!=-1){
		$_ =~ s|<.+?>||g;
		$_ =~ s|-SNAPSHOT||g;
		$_ =~ s/^\s+|\s+$//g;
		@version = split(/\./,$_);
		print "Old version:".$version[0]."\.".$version[1]."\.".$version[2]."\n";
		$new_version = "";
		if($minor == 1){
			$new_version = $version[0]."\.".($version[1]+1)."\.0\n";
		}elsif($major == 1){
			$new_version = ($version[0]+1)."\.0\.0";
		}else{
			$new_version = $version[0]."\.".$version[1]."\.".($version[2]+1);
		}
		print $build_history "".$new_version." ".$date ." ".$hash." ".$username." ".$message." \n"; 
		print "New version:".$new_version."\n";
		chomp($new_version);
		print $new_pom "    <version>".$new_version."-SNAPSHOT"."</version>"."\n"
	}else{
		print $new_pom $_."\n";
	}
}
system("mv pom.xml pom_old.xml");
system("mv pom_new.xml pom.xml");
system("mvn3 package");
system("mv target/*.jar jars/")

