import os
import sys

dir_path = "/absolute/path/to/directory/"
# Make sure dir_path is ending in /
num_of_pages = 2
out_file = dir_path+"14010XXXX_CV.pdf"


cmd = "gs -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/screen -dNOPAUSE -dQUIET -dBATCH -sOutputFile="+out_file
# cmd = "gs -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/printer -dNOPAUSE -dQUIET -dBATCH -sOutputFile="+out_file
for i in range(1,num_of_pages+1):
	filename = dir_path+str(i)+".pdf"
	cmd = cmd+" "+filename

os.system(cmd)