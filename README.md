
## Table of Contents


- [LeaderBoard](#leaderboard)
- [Prerequisites](#prerequisites)
- [Project Flow](#project-flow)
  - [Splash Screen](#splash-screen)
  - [Home Activity](#home-activity)
  - [Submission Activity](#submission-activity)
 - [Dialogs](#dialogs)
  - [Information Dialog](#information-dialog)
  - [Success Dialog](#success-dialog)
  - [Error Dialog](#error-dialog)


<p align="center">
  <br>
  
  <p align="center">
   <img align="center" src="https://forthebadge.com/images/badges/built-for-android.svg" alt="droidconKE2020 built for Android">
  
   [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ochudidesterio/LeaderBoard)
  </p>
  



  
  
  
  <h3 align="left">LeaderBoard</h3>

  <p align="Justify">
    This is an android application developed using java and it functions to retrieve the top learners and top learners with high IQ skills from Google Africa Developer 
Scholarship leaderboard API and display them in a recycler view on a tab layout activity using Volley. One tab for top learners and another tab for top IQ skills. The application also
has a submission form that submits a github link together with user names and email address to Google form using a reftrofit2 POST method.
    <br>
</p>


<br>

 

## Prerequisites

- You must have android studio 3.6 and above installed.

- You must have an emulator running on API level 21 or higher or a physical device with android 5 and above

- Fundamental Knowlegde of ViewPager,Adapters,recyclerViews,Volley and Retrofit

## Project Flow


## Splash screen

This is the laucher activity of the whole application.

![SplashScreen](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/splash%20Screen.png?raw=true)

## Home Activity

An activity with two tabs, one for top learners and another for top Skill IQs. The tablayout headings are added using PagerAdapter.

![Top Learners](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/top%20learners.png?raw=true)         ![Top Skill IQ](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/top%20IQ.png?raw=true)

## Submission Activity

This activity is launched via intent from the clickListener in the submit button on the Home Activity.

![Submission form](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/submission%20form.png?raw=true)


# Dialogs

## Information dialog

This is a dialog that is triggered upon the onclick of submit button on the Submission activity form.

![Information Dialog](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/Information%20Dialog.png?raw=true)

## Success dialog

This dialog pops up when the submision was successful

![Success Dialog](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/Success%20Dialog.png?raw=true)

## Error Dialog

And if the submission was not succesfull, the dialog below pops on the activity

![Error Dialog](https://github.com/ochudidesterio/LeaderBoard/blob/master/images/Error%20Dialog.png?raw=true)
