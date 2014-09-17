SMS_Blocker
===========

A app to block the SMS app on Android. This is done by launching a thread when the app itself it launch and that thread
repeats itself every one second. Every second, the app monitors all of the apps that are launched and if those apps happed to be the
SMS app (com.android.mms) it will directly go to the homescreen. You can edit which apps are blocked by editing the code within the 
block(); method.

===========

This repo has since moved to BitBucket.
