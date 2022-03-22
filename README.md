Project for LyIt 

To get access to this application from the internet
you have to allow your Chrome browser to:
"
Prevents non-secure contexts from making sub-resource requests to more-private IP addresses.
An IP address IP1 is more private than IP2 if 1) IP1 is localhost and IP2 is not, or 2) 
IP1 is private and IP2 is public. This is a first step towards full enforcement of CORS-RFC1918:
https://wicg.github.io/cors-rfc1918 – Mac, Windows, Linux, Chrome OS, Android, Fuchsia
"
You can do this by past this string to your browse's address bar.

chrome://flags/#block

Then you should find 
 * Block insecure private network requests. and change it to Disabled

