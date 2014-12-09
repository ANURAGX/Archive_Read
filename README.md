![Archive Read](http://s27.postimg.org/hxotyqxbn/Untitled.png "Archive Read")
=====

### ABOUT The LIBRARY....
The simple and useful library for android app developers to read archives like zip , rar , tar , tar.gz, tar.bz2.

Just provide the archive path to the library and leave the rest to the library to do.
This library will directly give "list adapter" to inflate in the listview or gridview. 

### USAGE....

  -i). Declare the manager instance.
-		private ReadArchive read = new ReadArchive(file);
-		//file should be and archive type line File file = new File("/sdcard/zipfile.zip");
-  ii).Then listview.setAdapter(read.getAdapter("/", context)); 
-       and you are done....	
-       "/" is root path for zip archive....
-       Similarly you can provide other paths to traverse inside archive....


### Installing Demo apk....
-Download the demo apk <a href="https://www.dropbox.com/sh/6ngrkjns4mg6j6l/AACextngfXnMIvFygEq2rClxa?dl=1">here</a> 
-Then sideload the apk and install it and explore the working of the library...

### Submitting Bug Reports....
When submitting a bug report, please include the following:-
 -Phone Model
 -Android Verison
 -Custom ROM?
 -Error report (please give as much information as possible, not just a couple lines from logcat)

### TODO....
 Add ability to read password protected and splitted archives.

### Used in FILE QUEST FILE MANAGER....
<img src="http://s29.postimg.org/rmrwvh5c7/Untitled.png" width="720px" height="600px"/>

