package proj1;
import java.util.*;
class node
{
	node lc,rc;
	String name;
	String meaning;
	int h;
	public node(String name,String meaning)   //parameterized constructor of class node
	{
		this.name=name.toLowerCase();
		this.meaning=meaning; 
		lc=rc=null;
		h=1;
	}
}

class AVL
{
	Scanner sc = new Scanner (System.in);
	private node root;   
	public AVL()
	{
		root=null;
	}
	
	int height(node N)   // height to calculate balance factor of tree
	{
		int lh, rh;			//utility function for balance function
		if(N == null)
		return 0;
		if(N.lc == null)	
		lh = 0;					
		else				
		lh = 1 + N.lc.h;		
		if(N.rc == null)
		rh = 0;
		else
		rh = 1 + N.rc.h;
		if(lh > rh)
		return lh;
		else
		return rh;
	}
	
	int balanceFactor(node root)   //to calculate the balance factor
	{int bf, lh, rh;
	if(root == null)
		return 0;
		if(root.lc == null)
		lh = 0;						//utility function
		else
		lh = 1 + height(root.lc);
		if(root.rc == null)		
		rh = 0;
		else
		rh = 1 + height(root.rc);
		bf = lh - rh;
		return bf;
		
	}
	
node LL(node ptr)   
	{				
	//Right Rotation
	node tmp = ptr.lc;
	ptr.lc = tmp.rc;		
	tmp.rc = ptr;
	tmp.h = height(tmp);
	ptr.h = height(ptr);
	return tmp;
	}
	
	node RR(node ptr)    
	{
		//Left Rotation
		node tmp = ptr.rc;
		ptr.rc = tmp.lc;
		tmp.lc = ptr;			
		tmp.h = height(tmp);
		ptr.h = height(ptr);
		return tmp;	
	}
	
	node LR(node root)
	{		//left right rotation
		root.lc=RR(root.lc);
		root=LL(root);				
		return root;
	}
	
	node RL(node root)    
	{
		root.rc=LL(root.rc);//right left rotation		
		root=RR(root);
		
		return root;
	}
	
	
	node insert(node root, node temp){//insert function	
		int bf;
		if(root == null){
		root = new node(temp.name, temp.meaning);
		return root;
		}
		if(temp.name.compareTo(root.name) < 0){
		root.lc = insert(root.lc, temp);
		bf = balanceFactor(root);
		if(bf == 2){
		if(temp.name.compareToIgnoreCase(root.lc.name) < 0)
		root = LL(root);
		else
		root = LR(root);
		}
		}
		else{ //cn.compareToIgnoreCase(root.Name) > 0
		root.rc = insert(root.rc, temp);
		bf = balanceFactor(root);
		if(bf == -2){
		if(temp.name.compareToIgnoreCase(root.rc.name) > 0)
		root = RR(root);
		else
		root = RL(root);
		}
		}
		root.h = height(root);
		return root;
	}
	
	void create(String Name,String mean)    //creation of a node
	{
		
		node temp=new node(Name,mean);
		root=insert(root,temp);
		
		
	}
	void display(node localRoot)        //Inorder  traversal 
	{
			if(localRoot != null){
			display(localRoot.lc);
			System.out.println(localRoot.name.toUpperCase()+" -"+localRoot.meaning);
			display(localRoot.rc);
			}
			
	}
	node getRoot() {//utility function for restricted access
		return root;		
	}
	void findWord() {
		System.out.print("\nEnter word : ");
		String target=sc.nextLine().toLowerCase();
		node current=root;
		while(current!=null) {
			int comparison=target.compareTo(current.name);
			if(comparison==0) {
				System.out.println("\nWord : "+current.name.toUpperCase()+"\t\t-\t\tMeaning : "+current.meaning);
				return;
			}
			else if(comparison<0) {//negative
				current=current.lc;
			}
			else {//comparison>0 //positive
				current=current.rc;
			}
		}
		System.out.println("\nWord not found! Please be more specific.");
	}
	int displayWordsAt(node head,String i,int t)   //display the words starting with a given letter
	    {  
	        if (head != null)  
	        {  if(head.name.startsWith(i)) {
	        	t++;
	        	System.out.println("Word : "+head.name.toUpperCase()+"\t\t-\t\tMeaning : "+head.meaning);
	        }
	        t=displayWordsAt(head.lc, i,t);  
	        t=displayWordsAt(head.rc, i,t);
	        return t;
	        }
			return t;  
	        
	    }

		
	
	int totalWordsCount(node r) {
	         if (r == null) {	//count of total nodes
	             return 0;
	         }
	         else
	         {
	             int l = 1;
	             l += totalWordsCount(r.lc);
	             l += totalWordsCount(r.rc);
	             return l;
	         }
	     
		
	}
	
	int wordCountAt(node loc,char j) {
				//count of words starting with a given letter
		if(loc==null)
			return 0;
		int count=0;
		if(loc.name.charAt(0)==j)
			count++;
		
		return count+wordCountAt(loc.lc,j)+wordCountAt(loc.rc,j);
		
		
		}
	void wordStartsWithVowel() {			//Display words starting with vowels
		System.out.println("\nStarts with Vowel : 'a' \n");
		displayWordsAt(root,"a",0);
		System.out.println("\nStarts with Vowel : 'e' \n");
		displayWordsAt(root,"e",0);
		System.out.println("\nStarts with Vowel : 'i' \n");
		displayWordsAt(root,"i",0);
		System.out.println("\nStarts with Vowel : 'o' \n");
		displayWordsAt(root,"o",0);
		System.out.println("\nStarts with Vowel : 'u' \n");
		displayWordsAt(root,"u",0);
	}
	void wordCountStartsWithVowel() {
		int t=0;
		{				//display the count of words starting with vowels
		int c= wordCountAt(root,'a');
		System.out.println("Total no. of words starting with vowel : 'a' are - "+c);
		t=t+c;
		}
		{
			int c= wordCountAt(root,'e');
			System.out.println("Total no. of words starting with vowel : 'e' are - "+c);
			t=t+c;
		}
		{
			int c= wordCountAt(root,'i');
			System.out.println("Total no. of words starting with vowel : 'i' are - "+c);
			t=t+c;
		}
		{
			int c= wordCountAt(root,'o');
			System.out.println("Total no. of words starting with vowel : 'o' are - "+c);
			t=t+c;
		}
		{
			int c= wordCountAt(root,'u');
			System.out.println("Total no. of words starting with vowel : 'u' are - "+c);
			t=t+c;
		}
		System.out.println("\nTotal no. of words starting with vowels are : "+t);
	}
}

public class Main{

	public static void main(String[] args) {
		AVL avl=new AVL();
		Scanner sc=new Scanner(System.in);
		avl.create("brb","Be right back");
		avl.create("btw","By the way");
		avl.create("ama", "Ask Me Anything");			//hard coded data
		avl.create("lmk","Let me know");
		avl.create("gtg","Got to go");
		avl.create("dm", "Direct Message");
		avl.create("idk", "I don't know");
		avl.create("rofl","Rolling on floor laughing");
		avl.create("stfu", "Shut the *swear word!* up");
		avl.create("icymi", "In case you missed it");
		avl.create("tl","Too long" );
		avl.create("ikr", "I know right");
		avl.create("dr", "Didn’t read");
		avl.create("nvm", "Nevermind");
		avl.create("tgif","Thank goodness it’s Friday");
		avl.create("tbh","To be honest");
		avl.create("tbf", "To be frank");
		avl.create("rn", "Right now");
		avl.create("qotd","Quote of the day");
		avl.create("ootd","Outfit of the day");
		avl.create("lol","Laugh out loud");
		avl.create("ttyl", "Talk to you later");
		avl.create("hit me up"," Hit me up");
		avl.create("fwiw", "For what it’s worth");
		avl.create("imo", "In my opinion");
		avl.create("imho", "In my humble opinion");
		avl.create("tba", "To be announced");
		avl.create("tbd", "To be decided");
		avl.create("ae","Accident & Emergency");
        avl.create("af","Always And Forever");
        avl.create("afe","Abercrombie & Fitch");
        avl.create("ar","Artists & Repertoire");
        avl.create("an","Author's Note");
        avl.create("aw","Anyway");
        avl.create("a1","Top quality");
        avl.create("a2dp","Advanced Audio Distribution Profile");
        avl.create("a3","Anywhere, Any time, Any place");
        avl.create("a4u","All For You");
        avl.create("a7a","Frustration, anger (Arabic)");
        avl.create("a7x","Avenged Sevenfold (band)");
        avl.create("aa","Alcoholics Anonymous");
        avl.create("aab","Average At Best");
        avl.create("aac","Apple Audio Compression");
        avl.create("aak","Alive And Kicking");
        avl.create("aamof","As A Matter Of Fact");
        avl.create("aap","Always A Pleasure");
        avl.create("aar","At Any Rate");
        avl.create("aarp","American Association of Retired Persons");
        avl.create("aat","And Another Thing");
        avl.create("aawy","And Also With You");
        avl.create("aayf","As Always, Your Friend");
        avl.create("abbo","Accountants Bookkeepers and Business Owners");
        avl.create("e","Ecstasy");
        avl.create("eoe","Errors and omissions excluded");
        avl.create("ecig","Electronic Cigarett");
        avl.create("edating","Online dating");
        avl.create("evite","Electronic Invitation");
        avl.create("ev","Everyone");
        avl.create("eeg","Ear To Ear Grin");
        avl.create("ea","Electronic Arts");
        avl.create("eas","End of Active Service");
        avl.create("eb","Eyeball");
        avl.create("ebcak","Error Between Chair And Keyboard");
        avl.create("ebd","End of Business Day");
        avl.create("ebm","Electronic Body Music");
        avl.create("ebony","Dark skin tone");
        avl.create("ebt","Electronic Benefits Transfer");
        avl.create("ecg","Electrocardiogram");
        avl.create("eco","Ecological");
        avl.create("ect","Misspelling of 'etc'");
        avl.create("ecu","Electronic Control Unit");
        avl.create("ecw","Extreme Championship Wrestling");
        avl.create("edc","Every Day Carry");
        avl.create("edd","Estimated Delivery Date");
        avl.create("eddress	","Email address");
        avl.create("edgy","Cutting edge");
        avl.create("edith","Even Dead, I'm The Hero");
        avl.create("ial","I Ain't Laughing");
        avl.create("ialto","I Always Love That One");
        avl.create("iama","I Am Mildly Amused");
        avl.create("ianand","I Am Not A Doctor");
        avl.create("ianal","I Am Not A Lawyer (this is an uninformed opinion)");
        avl.create("iakrt","I already know that");
        avl.create("ias","In A Second");
        avl.create("iatco","I Am The Cool One");
        avl.create("iau","I Adore You");
        avl.create("iaw","In Accordance With");
        avl.create ("iawtc","I Agree With That/This Comment");
        avl.create("iawtcsm	","I Agree With This Comment So Much");
        avl.create("iawtp","I Agree With This Post");
        avl.create("o","Ounce (of drugs)");
        avl.create("orly","Oh, Really?");
        avl.create("oo","Over and Out");
        avl.create("oa","Over Acting");
        avl.create("oan","On Another Note");
        avl.create("oao","Over And Out");
        avl.create("oap","Old Age Pensioner");
        avl.create("oatus","On A Totally Unrelated Subject");
        avl.create("oaus","On An Unrelated Subject");
        avl.create("ob","Oh, Brother");
        avl.create("obby","Oh, Baby");
        avl.create("obe","Overcome By Events");
        avl.create("obgyn","Gynecologist (OBstetrics and GYNecology)");
        avl.create("obhwf","One Big Happy Weasely Family");
        avl.create("obo","Or Best Offer");
        avl.create("obq","Oh, Be Quiet");
        avl.create("obs","Obviously");
        avl.create("obtw","Oh, By The Way");
        avl.create("obv","Obviously");
        avl.create("obx","Outer Banks North Carolina");
        avl.create("oc","Of Course");
        avl.create("ocd","Obsessive Compulsive Disorder");
        avl.create("och","Oh (Scottish)");
        avl.create("ocn","Of Course Not");
        avl.create("oco","Oh, Come On");
        avl.create("ocr","Optical Character Recognition");
        avl.create("oct","On Company Time");
        avl.create("od","Overdose");
        avl.create("lit", "When something is very good" );  
        avl.create("extra","Dramatic");
        avl.create("salty","When someone is upset"); 
        avl.create("flex","Someone is showing off");
        avl.create("highkey","Liked something secretly");
        avl.create("shook","They are shocked or incredibly surprised");
        avl.create("spilling the tea","They are gossiping");
        avl.create("wallflower","A shy person");
        avl.create("busted ","Getting caught");
        avl.create("g2g","Got to go");
        avl.create("lurker","When someone visits a forum often");
        avl.create("faq","Frequently asked questions");
        avl.create("pwned","Defeated or humiliated");
        avl.create("lag","When computer application is slow");
        avl.create("noob","When someone is new to something");
        avl.create("photobomb","When someone or something appears in a photo unexpectedly");
        avl.create("spam","Type of email which is not meaningful");
        avl.create("trending","Popular or fashionable at a moment");
        avl.create("handle ","Nickname for a website");
        avl.create("haha","Laughter");
        avl.create("irl","In real life");
        avl.create("nsfw","Not safe for work");
        avl.create("dr","Didn't read");
        avl.create("otl","Emoji used to show an expression or feeling");
        avl.create("wack"," Bad ,wrong ,worthless");
        avl.create("wacko","Crazy, insane.");
        avl.create("wacky","Crazy, zany.");
        avl.create("wad",	"(Noun) A large amount of money.");
        avl.create("nab", "To catch someone doing something wrong.");
        avl.create("nail","To do something perfectly.");
        avl.create("narc","A narcotics officer, a police officer working in drug trade suppression.");
        avl.create("nark","A police officer working in drug trade suppression.");
        avl.create("neat","Very good, excellent.");
        avl.create("nerd","A studious person with few social skills.");
        avl.create("ocker","A crude and obnoxious Australian.");
        avl.create("od","To take an overdose of a drug.");
        avl.create("oddball","A strange or eccentric person  ");
        avl.create("off","To murder, to kill.");
        avl.create("off the hook","No longer suspected of guilt ");
        avl.create("pack heat","To carry a gun.");
        avl.create("pack it in","To stop what you're doing, to quit.");
        avl.create("pain in the arse","Someone or something that's annoying or troublesome.");
        avl.create("pain in the ass","An annoying or troublesome person or thing.");
        avl.create("pal","A friend.");
        avl.create("quick sticks","Quickly. ");
        avl.create("quid","One pound sterling.");
        avl.create("quids-in","In profit. ");
        avl.create("quilt","A feeble or pathetic person. ");  
        avl.create("quack","doctor");
        avl.create("laa","Lad");
        avl.create("labtop","Laptop");
        avl.create("lacking","Without a weapon, specifically a gun");
        avl.create("lad","Guy");
        avl.create("maab","Male-Assigned At Birth");
        avl.create("mac","Media Access Control");
        avl.create("maching","Going at maximum Speed (skiing or biking)");
        avl.create("mack","Flirt");
        avl.create("mad","Really, extremely");
        avl.create("madd","Mothers Against Drunk Driving");
        avl.create("mag","Magazine");
        avl.create("jaja","Spanish laugh");
        avl.create("b","Bro");
        avl.create("ban","Banned");
        
        avl.create("bb","Baby");
        avl.create("bd","Bondage And Discipline");
      
        avl.create("be","Breaking And Entering");
        avl.create("C","Very happy");
        avl.create("caac","Cool As A Cucumber");
        avl.create("cab","Misspelling of CBA");
        avl.create("cachai","Do you understand?");
        avl.create("cache","Store for temporary computer files");
        avl.create("cactus","Broken, dead");
        avl.create("dada","Defence Against the Dark Arts (Harry Potter)");
        avl.create("dadt","Don't Ask, Don't Tell");
        avl.create("dae","Does Anybody Else");
        avl.create("dag","Damn");
       
        avl.create("daggy","Uncool, not trendy, untidy");
        avl.create ("faa","Federal Aviation Administration)");
        		
        avl.create( "faab","Female-Assigned At Birth");
        avl.create("faak","Falling Asleep At Keyboard");
        avl.create ("fab","Fabulous");
        avl.create("fabu","Fabulous");
        avl.create("ga	","Go Ahead");
        avl.create("gac","Guilty As Charged");
      
        avl.create("gaff","House");
        avl.create("gafaia","Get Away From It All");
        avl.create("gafm","Get Away From Me");
        avl.create("gag","About to throw up");
        
        avl.create("ha","Sarcastic laugh");
        avl.create("habbo","Online community/game");
        avl.create("habibi","My darling (Arabic)");
        avl.create("hac","Asian Chick");
        avl.create("hacer","Hacker");
        avl.create("jaf","Just A Friend");
        
        avl.create("jag","Socially inept person");
        avl.create("jah","God,Jehovah");
        avl.create("jailbreak","Crack an iPhone");
        avl.create("kd","Kraft Dinner");
        avl.create("kda","Kills / Deaths / Assists");
        avl.create("kdr","Kill/Death Ratio");
        avl.create("keed","Kid, joke");
        avl.create("keel","Kill");
        avl.create("lsa","Cantonese Exclamation");
        avl.create ("rabbit on","To talk for a long time, esp. ");
        avl.create ("racket","Loud noise that lasts a long time.");
        avl.create ("racket","A dishonest or illegal activity that makes money.");
        avl.create ("rap","To talk together in a relaxed way ");
        avl.create ("rap","To recite lyrics over a rhythmic beat.");
        avl.create ("s.p.","British slang for the odds on a horse; essential information, the known form.");
        avl.create ("s.t.p.","Slang for a particular hallucinogenic drug similar to, but more powerful than LSD.");
        avl.create ("sab","British slang for sabotage.");
        avl.create ("sabbing","British slang for sabotage.");
        avl.create ("tad","Slightly, a little.");
        avl.create ("tail","A person who's following someone to find out where they're going and what they're doing.");
        avl.create ("take","Stolen money or goods.");
        avl.create ("tee off","To make someone angry, to annoy.");
        avl.create ("thick","Not very intelligent, a bit slow mentally.");
        avl.create ("ugg boots","Soft sheepskin boots that originated in Australia.");
        avl.create ("ump","Umpire.");
        avl.create ("umpteen","Many, countless.");
        avl.create ("uncle sam","The U.S.A., the U.S. government.");
        avl.create ("uncool.","Not good, not acceptable, not fashionable.");
        avl.create  ("uac","User Account Control");
        avl.create  ("uae",	"United Arab Emirates");
        avl.create ("uak","You Already Know");
        avl.create  ("uan","Universal Access Number");
        avl.create ("uark","You Already Know");
        avl.create  ("uav","Urban Assault Vehicle");
        avl.create("ub","You biggit");
        avl.create  ("ubt","You Be Too");
        avl.create ("ubber","Uber, very");
        avl.create  ("ubd","User Brain Damage");
        avl.create ("v","Black−American slang for an unfriendly female");
        avl.create ("v.a.t.","British slang for vodka and tonic.");
        avl.create ("v.c.","American slang for Viet Cong, a north Vietnamese combatant.");
        avl.create ("vac","British slang for a university or other higher education holiday.");
        avl.create ("vacuum cleaner","Black−American slang for ones lungs");
        avl.create("zilchNothing","Zero");
        avl.create("zibi","Person from Zimbabwe");
        avl.create("zing","Owned");
        		
        avl.create("zip","Ounce of marijauna");
       avl.create ("zit","Spot, pimple");
       avl.create("zoinks","jeepers");
       avl.create("yacc","Yet Another Compiler-Compiler");
       avl.create("yam","And so on, blah");
       avl.create("yagb","You Ain't Grizz Baby (COD)");
      avl.create("yahoo","Yob, lout");
       avl.create("yahwej","The name of God in hebrew");
      avl.create("yak","You Already Know");
      avl.create("xkcd","Web comic");
      avl.create ("xl","Extra Large");
      avl.create("xlnt","Excellent");
      avl.create ("xlr","Accelerate");
      avl.create ("xls","MS Excel file extension");
      avl.create("xm","Extreme");
      avl.create ("waa","Crying");
      avl.create ("waam","What's going on, what's up");
      avl.create ("waan","Want");
      avl.create("wack","Low quailty, lame");
      avl.create ("wadr","With All Due Respect");
      avl.create("waefrd","When All Else Fails, Read Directions");
        
		int ch;
		do{
			System.out.println("**************************** Menu ********************************");
			System.out.println("1.Find a Word");
			System.out.println("2.Display words starting with given letter");
			System.out.println("3.Total no. of words in dictionary");
			System.out.println("4.Total no. of words starting with given letter");
			System.out.println("5.Display all words");
			System.out.println("6.Display Words starting with vowels");//words at 
			System.out.println("7.Total no. of words starting with vowels");
			System.out.println("8.Exit");
			System.out.println("******************************************************************");
			System.out.print("Enter your choice : ");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				
				avl.findWord(); 
			break;
			case 2: 
				System.out.print("\nEnter the starting letter of the words you want to find : ");
				String c=sc.next();
				if(c.length()!=1) {
					System.out.println("\nEnter a single letter!");		//validation for a letter
					break;
				}
				else {
					int j=0;
				if(avl.displayWordsAt(avl.getRoot(),c,j)==0)
					System.out.println("No word starts with the letter '"+c+"'");
				break;
				}
			case 3: System.out.println("\nTotal no. of words in the dictionary are : "+avl.totalWordsCount(avl.getRoot())); 
			break;
			case 4: System.out.print("\nEnter the starting letter of the words you want to find : ");
			String b=sc.next();
			if(b.length()!=1) {
				System.out.println("\nEnter a single letter!");
				break;
			}
			else {
			System.out.println(avl.wordCountAt(avl.getRoot(),b.toLowerCase().charAt(0))); 
			break;
			}
			case 5:
				avl.display(avl.getRoot());
				break;
			case 6:
				avl.wordStartsWithVowel();
				break;
			case 7:
				avl.wordCountStartsWithVowel();
				break;
			case 8: System.out.println("Program ended"); 
			
			break;
			default: System.out.println("Invalid option");
			
			}
			} while(ch != 8);
			sc.close(); //sc is closed
	}

}

/**********************************************************************
 * TIME COMPLEXITY:
 * height() O(1)
 * balanceFactor() O(1)
 * LL() O(1)
 * RR() O(1)
 * RL() O(1)
 * LR() O(1)
 * insert() O(logn)
 * create() O(1)
 * display() O(n)
 * getRoot() O(1)
 * findWord() O(n)
 * displayWordsAt() O(logn)
 * totalWordsCount (logn)
 * wordCountAt()	O(logn)
 * wordStartsWithVowel() O(logn)
 * wordCountStartsWithVowel() O(logn)
***********************************************************************/
/*
OUTPUT:
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 1

Enter word : lol

Word : LOL		-		Meaning : Laugh out loud
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 2

Enter the starting letter of the words you want to find : k
Word : KD		-		Meaning : Kraft Dinner
Word : KDA		-		Meaning : Kills / Deaths / Assists
Word : KDR		-		Meaning : Kill/Death Ratio
Word : KEED		-		Meaning : Kid, joke
Word : KEEL		-		Meaning : Kill
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 3

Total no. of words in the dictionary are : 279
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 4

Enter the starting letter of the words you want to find : f
8
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 5
A1 -Top quality
A2DP -Advanced Audio Distribution Profile
A3 -Anywhere, Any time, Any place
A4U -All For You
A7A -Frustration, anger (Arabic)
A7X -Avenged Sevenfold (band)
AA -Alcoholics Anonymous
AAB -Average At Best
AAC -Apple Audio Compression
AAK -Alive And Kicking
AAMOF -As A Matter Of Fact
AAP -Always A Pleasure
AAR -At Any Rate
AARP -American Association of Retired Persons
AAT -And Another Thing
AAWY -And Also With You
AAYF -As Always, Your Friend
ABBO -Accountants Bookkeepers and Business Owners
AE -Accident & Emergency
AF -Always And Forever
AFE -Abercrombie & Fitch
AMA -Ask Me Anything
AN -Author's Note
AR -Artists & Repertoire
AW -Anyway
B -Bro
BAN -Banned
BB -Baby
BD -Bondage And Discipline
BE -Breaking And Entering
BRB -Be right back
BTW -By the way
BUSTED  -Getting caught
C -Very happy
CAAC -Cool As A Cucumber
CAB -Misspelling of CBA
CACHAI -Do you understand?
CACHE -Store for temporary computer files
CACTUS -Broken, dead
DADA -Defence Against the Dark Arts (Harry Potter)
DADT -Don't Ask, Don't Tell
DAE -Does Anybody Else
DAG -Damn
DAGGY -Uncool, not trendy, untidy
DM -Direct Message
DR -Didn’t read
DR -Didn't read
E -Ecstasy
EA -Electronic Arts
EAS -End of Active Service
EB -Eyeball
EBCAK -Error Between Chair And Keyboard
EBD -End of Business Day
EBM -Electronic Body Music
EBONY -Dark skin tone
EBT -Electronic Benefits Transfer
ECG -Electrocardiogram
ECIG -Electronic Cigarett
ECO -Ecological
ECT -Misspelling of 'etc'
ECU -Electronic Control Unit
ECW -Extreme Championship Wrestling
EDATING -Online dating
EDC -Every Day Carry
EDD -Estimated Delivery Date
EDDRESS	 -Email address
EDGY -Cutting edge
EDITH -Even Dead, I'm The Hero
EEG -Ear To Ear Grin
EOE -Errors and omissions excluded
EV -Everyone
EVITE -Electronic Invitation
EXTRA -Dramatic
FAA -Federal Aviation Administration)
FAAB -Female-Assigned At Birth
FAAK -Falling Asleep At Keyboard
FAB -Fabulous
FABU -Fabulous
FAQ -Frequently asked questions
FLEX -Someone is showing off
FWIW -For what it’s worth
G2G -Got to go
GA	 -Go Ahead
GAC -Guilty As Charged
GAFAIA -Get Away From It All
GAFF -House
GAFM -Get Away From Me
GAG -About to throw up
GTG -Got to go
HA -Sarcastic laugh
HABBO -Online community/game
HABIBI -My darling (Arabic)
HAC -Asian Chick
HACER -Hacker
HAHA -Laughter
HANDLE  -Nickname for a website
HIGHKEY -Liked something secretly
HIT ME UP - Hit me up
IAKRT -I already know that
IAL -I Ain't Laughing
IALTO -I Always Love That One
IAMA -I Am Mildly Amused
IANAL -I Am Not A Lawyer (this is an uninformed opinion)
IANAND -I Am Not A Doctor
IAS -In A Second
IATCO -I Am The Cool One
IAU -I Adore You
IAW -In Accordance With
IAWTC -I Agree With That/This Comment
IAWTCSM	 -I Agree With This Comment So Much
IAWTP -I Agree With This Post
ICYMI -In case you missed it
IDK -I don't know
IKR -I know right
IMHO -In my humble opinion
IMO -In my opinion
IRL -In real life
JAF -Just A Friend
JAG -Socially inept person
JAH -God,Jehovah
JAILBREAK -Crack an iPhone
JAJA -Spanish laugh
KD -Kraft Dinner
KDA -Kills / Deaths / Assists
KDR -Kill/Death Ratio
KEED -Kid, joke
KEEL -Kill
LAA -Lad
LABTOP -Laptop
LACKING -Without a weapon, specifically a gun
LAD -Guy
LAG -When computer application is slow
LIT -When something is very good
LMK -Let me know
LOL -Laugh out loud
LSA -Cantonese Exclamation
LURKER -When someone visits a forum often
MAAB -Male-Assigned At Birth
MAC -Media Access Control
MACHING -Going at maximum Speed (skiing or biking)
MACK -Flirt
MAD -Really, extremely
MADD -Mothers Against Drunk Driving
MAG -Magazine
NAB -To catch someone doing something wrong.
NAIL -To do something perfectly.
NARC -A narcotics officer, a police officer working in drug trade suppression.
NARK -A police officer working in drug trade suppression.
NEAT -Very good, excellent.
NERD -A studious person with few social skills.
NOOB -When someone is new to something
NSFW -Not safe for work
NVM -Nevermind
O -Ounce (of drugs)
OA -Over Acting
OAN -On Another Note
OAO -Over And Out
OAP -Old Age Pensioner
OATUS -On A Totally Unrelated Subject
OAUS -On An Unrelated Subject
OB -Oh, Brother
OBBY -Oh, Baby
OBE -Overcome By Events
OBGYN -Gynecologist (OBstetrics and GYNecology)
OBHWF -One Big Happy Weasely Family
OBO -Or Best Offer
OBQ -Oh, Be Quiet
OBS -Obviously
OBTW -Oh, By The Way
OBV -Obviously
OBX -Outer Banks North Carolina
OC -Of Course
OCD -Obsessive Compulsive Disorder
OCH -Oh (Scottish)
OCKER -A crude and obnoxious Australian.
OCN -Of Course Not
OCO -Oh, Come On
OCR -Optical Character Recognition
OCT -On Company Time
OD -Overdose
OD -To take an overdose of a drug.
ODDBALL -A strange or eccentric person  
OFF -To murder, to kill.
OFF THE HOOK -No longer suspected of guilt 
OO -Over and Out
OOTD -Outfit of the day
ORLY -Oh, Really?
OTL -Emoji used to show an expression or feeling
PACK HEAT -To carry a gun.
PACK IT IN -To stop what you're doing, to quit.
PAIN IN THE ARSE -Someone or something that's annoying or troublesome.
PAIN IN THE ASS -An annoying or troublesome person or thing.
PAL -A friend.
PHOTOBOMB -When someone or something appears in a photo unexpectedly
PWNED -Defeated or humiliated
QOTD -Quote of the day
QUACK -doctor
QUICK STICKS -Quickly. 
QUID -One pound sterling.
QUIDS-IN -In profit. 
QUILT -A feeble or pathetic person. 
RABBIT ON -To talk for a long time, esp. 
RACKET -Loud noise that lasts a long time.
RACKET -A dishonest or illegal activity that makes money.
RAP -To talk together in a relaxed way 
RAP -To recite lyrics over a rhythmic beat.
RN -Right now
ROFL -Rolling on floor laughing
S.P. -British slang for the odds on a horse; essential information, the known form.
S.T.P. -Slang for a particular hallucinogenic drug similar to, but more powerful than LSD.
SAB -British slang for sabotage.
SABBING -British slang for sabotage.
SALTY -When someone is upset
SHOOK -They are shocked or incredibly surprised
SPAM -Type of email which is not meaningful
SPILLING THE TEA -They are gossiping
STFU -Shut the *swear word!* up
TAD -Slightly, a little.
TAIL -A person who's following someone to find out where they're going and what they're doing.
TAKE -Stolen money or goods.
TBA -To be announced
TBD -To be decided
TBF -To be frank
TBH -To be honest
TEE OFF -To make someone angry, to annoy.
TGIF -Thank goodness it’s Friday
THICK -Not very intelligent, a bit slow mentally.
TL -Too long
TRENDING -Popular or fashionable at a moment
TTYL -Talk to you later
UAC -User Account Control
UAE -United Arab Emirates
UAK -You Already Know
UAN -Universal Access Number
UARK -You Already Know
UAV -Urban Assault Vehicle
UB -You biggit
UBBER -Uber, very
UBD -User Brain Damage
UBT -You Be Too
UGG BOOTS -Soft sheepskin boots that originated in Australia.
UMP -Umpire.
UMPTEEN -Many, countless.
UNCLE SAM -The U.S.A., the U.S. government.
UNCOOL. -Not good, not acceptable, not fashionable.
V -Black−American slang for an unfriendly female
V.A.T. -British slang for vodka and tonic.
V.C. -American slang for Viet Cong, a north Vietnamese combatant.
VAC -British slang for a university or other higher education holiday.
VACUUM CLEANER -Black−American slang for ones lungs
WAA -Crying
WAAM -What's going on, what's up
WAAN -Want
WACK - Bad ,wrong ,worthless
WACK -Low quailty, lame
WACKO -Crazy, insane.
WACKY -Crazy, zany.
WAD -(Noun) A large amount of money.
WADR -With All Due Respect
WAEFRD -When All Else Fails, Read Directions
WALLFLOWER -A shy person
XKCD -Web comic
XL -Extra Large
XLNT -Excellent
XLR -Accelerate
XLS -MS Excel file extension
XM -Extreme
YACC -Yet Another Compiler-Compiler
YAGB -You Ain't Grizz Baby (COD)
YAHOO -Yob, lout
YAHWEJ -The name of God in hebrew
YAK -You Already Know
YAM -And so on, blah
ZIBI -Person from Zimbabwe
ZILCHNOTHING -Zero
ZING -Owned
ZIP -Ounce of marijauna
ZIT -Spot, pimple
ZOINKS -jeepers
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 6

Starts with Vowel : 'a' 

Word : A7X		-		Meaning : Avenged Sevenfold (band)
Word : A4U		-		Meaning : All For You
Word : A2DP		-		Meaning : Advanced Audio Distribution Profile
Word : A1		-		Meaning : Top quality
Word : A3		-		Meaning : Anywhere, Any time, Any place
Word : A7A		-		Meaning : Frustration, anger (Arabic)
Word : AAB		-		Meaning : Average At Best
Word : AA		-		Meaning : Alcoholics Anonymous
Word : AAK		-		Meaning : Alive And Kicking
Word : AAC		-		Meaning : Apple Audio Compression
Word : AAP		-		Meaning : Always A Pleasure
Word : AAMOF		-		Meaning : As A Matter Of Fact
Word : AARP		-		Meaning : American Association of Retired Persons
Word : AAR		-		Meaning : At Any Rate
Word : AE		-		Meaning : Accident & Emergency
Word : AAT		-		Meaning : And Another Thing
Word : AAWY		-		Meaning : And Also With You
Word : AAYF		-		Meaning : As Always, Your Friend
Word : ABBO		-		Meaning : Accountants Bookkeepers and Business Owners
Word : AW		-		Meaning : Anyway
Word : AMA		-		Meaning : Ask Me Anything
Word : AF		-		Meaning : Always And Forever
Word : AFE		-		Meaning : Abercrombie & Fitch
Word : AR		-		Meaning : Artists & Repertoire
Word : AN		-		Meaning : Author's Note

Starts with Vowel : 'e' 

Word : E		-		Meaning : Ecstasy
Word : EAS		-		Meaning : End of Active Service
Word : EA		-		Meaning : Electronic Arts
Word : EBCAK		-		Meaning : Error Between Chair And Keyboard
Word : EB		-		Meaning : Eyeball
Word : EBM		-		Meaning : Electronic Body Music
Word : EBD		-		Meaning : End of Business Day
Word : EOE		-		Meaning : Errors and omissions excluded
Word : EEG		-		Meaning : Ear To Ear Grin
Word : EDC		-		Meaning : Every Day Carry
Word : ECIG		-		Meaning : Electronic Cigarett
Word : EBONY		-		Meaning : Dark skin tone
Word : EBT		-		Meaning : Electronic Benefits Transfer
Word : ECG		-		Meaning : Electrocardiogram
Word : EDATING		-		Meaning : Online dating
Word : ECU		-		Meaning : Electronic Control Unit
Word : ECT		-		Meaning : Misspelling of 'etc'
Word : ECO		-		Meaning : Ecological
Word : ECW		-		Meaning : Extreme Championship Wrestling
Word : EDD		-		Meaning : Estimated Delivery Date
Word : EDDRESS			-		Meaning : Email address
Word : EDGY		-		Meaning : Cutting edge
Word : EDITH		-		Meaning : Even Dead, I'm The Hero
Word : EXTRA		-		Meaning : Dramatic
Word : EVITE		-		Meaning : Electronic Invitation
Word : EV		-		Meaning : Everyone

Starts with Vowel : 'i' 

Word : IAMA		-		Meaning : I Am Mildly Amused
Word : IAL		-		Meaning : I Ain't Laughing
Word : IAKRT		-		Meaning : I already know that
Word : IALTO		-		Meaning : I Always Love That One
Word : IKR		-		Meaning : I know right
Word : ICYMI		-		Meaning : In case you missed it
Word : IAU		-		Meaning : I Adore You
Word : IATCO		-		Meaning : I Am The Cool One
Word : IAS		-		Meaning : In A Second
Word : IANAND		-		Meaning : I Am Not A Doctor
Word : IANAL		-		Meaning : I Am Not A Lawyer (this is an uninformed opinion)
Word : IAW		-		Meaning : In Accordance With
Word : IAWTC		-		Meaning : I Agree With That/This Comment
Word : IAWTCSM			-		Meaning : I Agree With This Comment So Much
Word : IAWTP		-		Meaning : I Agree With This Post
Word : IDK		-		Meaning : I don't know
Word : IRL		-		Meaning : In real life
Word : IMO		-		Meaning : In my opinion
Word : IMHO		-		Meaning : In my humble opinion

Starts with Vowel : 'o' 

Word : OBQ		-		Meaning : Oh, Be Quiet
Word : OBE		-		Meaning : Overcome By Events
Word : OATUS		-		Meaning : On A Totally Unrelated Subject
Word : OAO		-		Meaning : Over And Out
Word : OA		-		Meaning : Over Acting
Word : O		-		Meaning : Ounce (of drugs)
Word : OAN		-		Meaning : On Another Note
Word : OAP		-		Meaning : Old Age Pensioner
Word : OB		-		Meaning : Oh, Brother
Word : OAUS		-		Meaning : On An Unrelated Subject
Word : OBBY		-		Meaning : Oh, Baby
Word : OBHWF		-		Meaning : One Big Happy Weasely Family
Word : OBGYN		-		Meaning : Gynecologist (OBstetrics and GYNecology)
Word : OBO		-		Meaning : Or Best Offer
Word : OBX		-		Meaning : Outer Banks North Carolina
Word : OBTW		-		Meaning : Oh, By The Way
Word : OBS		-		Meaning : Obviously
Word : OBV		-		Meaning : Obviously
Word : OCN		-		Meaning : Of Course Not
Word : OCD		-		Meaning : Obsessive Compulsive Disorder
Word : OC		-		Meaning : Of Course
Word : OCH		-		Meaning : Oh (Scottish)
Word : OCKER		-		Meaning : A crude and obnoxious Australian.
Word : ORLY		-		Meaning : Oh, Really?
Word : OOTD		-		Meaning : Outfit of the day
Word : OCR		-		Meaning : Optical Character Recognition
Word : OCO		-		Meaning : Oh, Come On
Word : OO		-		Meaning : Over and Out
Word : OCT		-		Meaning : On Company Time
Word : OD		-		Meaning : Overdose
Word : OD		-		Meaning : To take an overdose of a drug.
Word : ODDBALL		-		Meaning : A strange or eccentric person  
Word : OFF		-		Meaning : To murder, to kill.
Word : OFF THE HOOK		-		Meaning : No longer suspected of guilt 
Word : OTL		-		Meaning : Emoji used to show an expression or feeling

Starts with Vowel : 'u' 

Word : UNCOOL.		-		Meaning : Not good, not acceptable, not fashionable.
Word : UMPTEEN		-		Meaning : Many, countless.
Word : UARK		-		Meaning : You Already Know
Word : UAN		-		Meaning : Universal Access Number
Word : UAK		-		Meaning : You Already Know
Word : UAE		-		Meaning : United Arab Emirates
Word : UAC		-		Meaning : User Account Control
Word : UGG BOOTS		-		Meaning : Soft sheepskin boots that originated in Australia.
Word : UAV		-		Meaning : Urban Assault Vehicle
Word : UB		-		Meaning : You biggit
Word : UBT		-		Meaning : You Be Too
Word : UBBER		-		Meaning : Uber, very
Word : UBD		-		Meaning : User Brain Damage
Word : UMP		-		Meaning : Umpire.
Word : UNCLE SAM		-		Meaning : The U.S.A., the U.S. government.
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 7
Total no. of words starting with vowel : 'a' are - 25
Total no. of words starting with vowel : 'e' are - 26
Total no. of words starting with vowel : 'i' are - 19
Total no. of words starting with vowel : 'o' are - 35
Total no. of words starting with vowel : 'u' are - 15

Total no. of words starting with vowels are : 120
**************************** Menu ********************************
1.Find a Word
2.Display words starting with given letter
3.Total no. of words in dictionary
4.Total no. of words starting with given letter
5.Display all words
6.Display Words starting with vowels
7.Total no. of words starting with vowels
8.Exit
******************************************************************
Enter your choice : 8
Program ended

*/