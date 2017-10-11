# packt-lean-saas-canvapp

Android sample app using FireBase as mBaaS. It is a very simple 'share your business model canvas' app. 

While an MVP could be something as minimal as a landing page, announcing your app, or a live mock up version of your app, there comes a time that your app should be a little more than that, whether it is to prove your next hypotheses or to see the actual thing in its most basic shape in action. It's about time to create a Proof of Concept (PoC).

Standalone apps are rare these days. Most apps have functionality to share content on Twitter or Facebook, have leaderboards (if it is a game), let user post pictures or video, have a chat or otherwise communicate with each other and so on. For this your app needs to have a backend. 

You can of course create your own API or use the API of the many solutions that do exist for this purpose, the so called mobile Backend as a Service (mBaaS). These solutions do work like any other Software as a Service (SaaS) but are specifically intended for this purpose.

We will have a look on mBaaS solutions and will see what it takes to build an Android POC using FireBase, a popular cloud based backend.


# Lean mobile app development book

This sample is described in chapter 8, called Cloud Solutions for App Experiments in the book 'Lean mobile app development'. It will arrive by the end of this year.

In this chapter we will see how we can organize a workflow in which we automate the process of testing and delivering your app.  You can do this for both the beta and the public releases of your app.  To make the build-measure-feedback loop really work you, you need to release early and often. 

You can install Jenkins or TeamCity on a build server or another dedicated machine to make a new build of your app each time a new feature becomes available. Basically it comes down to that but there are many interesting strategies to consider. For example: What is your branching strategy (git workflow)? Do you want to run unit or UI-tests on the build server? How can you support variants (Android) or targets (iOS) for your app? Let’s find out in this chapter.
We will have a look at various tools that can help us with the ad hoc distribution of the app. 
