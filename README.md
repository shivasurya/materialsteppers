# Material Design Steppers 
[ ![Download](https://api.bintray.com/packages/shivasurya/materialsteppers/materialstepper/images/download.svg) ](https://bintray.com/shivasurya/materialsteppers/materialstepper/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Material%20Design%20Steppers-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3049)
#### Google Material Design Steppers Component  - Android Java - <a href="https://www.google.co.in/design/spec/components/steppers.html">Official Link</a>
<br>
`compile 'ivb.com.materialstepper:material-stepper:0.0.1'`
<br />
<br />
1. Create Java Class and Extend **progressMobileStepper ** or **simpleMobileStepper** Activity.<br/>
2. Implement Methods **List<Class> init()** method and **void onStepperCompleted()** .<br />
3. Create Fragments by Extending **stepperFragment** and implement Method **boolean onNextButtonHandler()**.<br/>
4. Use **onNextButtonHandler** method to handle UI validation inside Fragments,whenever the user presses the Next Button,return true/false inorder to determine to Stay or move to next Fragment.<br/>
5. Make it as ArrayList with Class containing fragments and return via **List<Class> init()** method - Mentioned in 1st point.<br/>
6. use **onStepperCompleted** method to complete stepper and finalize the activity.
7. It's upto Developer to use savedInstanceState to save the Data since the fragments will be initialized only when needed,At most of the time it will be destroyed.(To Avoid Memory Overhead and Leaks).

<hr>
**Note** : with the given List size : step count will be Computed and Updated,Increasing and dynamic fragment feature may be added in future Commits,<br>
Scrollview have been adopted for ViewPager(fragment) inbuilt to scroll,So no worries for small/Large Screens.Added support for both Landscape and Portait Mode by adopting SavedInstanceState.(However Your Data inside fragment is not gauranteed so,use SavedinstanceState)
##DEMO : 
Included the Example Demo app in <a href="https://github.com/shivasurya/materialsteppers/tree/master/example">example project</a>,Download and Sync with gradle.build <br>
<b>Screenshot : </b>
<hr>
<img src="https://lh3.googleusercontent.com/2ryony7pO7evMgwuxn7iZCk6uYHVt0oLiA4RR7GY4MeobNbA4WT07Cpwxds9sjMqCrkU7ZKoaEHmIjg9ONK_6qT5xi4UEkxr8VffNoR_7u31rtMXN2lB9TXtx0ADC2YyDIXj5sHlEU8GzwaOsO-dm7v-BREpkQMcLJWL_qMXOwPSsUplJ5nPNiO52qHp_Tq1fTSI0UvApMB5EGPYvoNx0mw8zJOkd47X2VtlO4bbXZouZ83jet5pgp-k50_tNFDAIfjtmJiWS-cruL9QN6kqjYLupsRPNfwBAVKRcIIhKpl_tzSjNurhxLHuiZaJx7ayd0469JaFREQH-gLU6B45Bne1KJ2Ke1lB-RaGtTOgW1z6ni8zNGgAXpwWB67fCjufBRK0R-Q8s_65FL0qFhy645d8tGcIhTudLbVPpSUtmLcdZmvnVY6aiwdIO4k09ykWOj_dkNe6jj0Fsw1t-_ZpktGZrRIRBAJwAxbCvnrAFqlZOhZPwc1JDz69Xt5a8nDRGwauMVpTzij9bZ5rz2KnMlNi5xRRY2-r-4hMWLpQLph7nVLovc3jGaR7uspneRO1zxCn=w264-h265-no" alt="demo screenshot">
## Use of this Library :
<hr>
1) Payment Processing Steps for Checkouts <br />
2) Account verification and creation <br />
3) Survey Apps and Form fillup driven apps (Highly Recommended) <br />
4) Any Accomplishment apps and Task driven apps. <br >
<hr>

##Motive behind this Library:
<hr >
Hello,i'm shivasurya,Pre-Final year UG Student from INDIA<br />
i have been developing apps for more than a year,Developed Android Material Design Component using Existing Support Library v4 ViewPager named as Material Steppers.Initially developed for part of College Project and open sourced for further development and enhancement of the library in Github.Constantly working on the library to improve features and fix memory Leaks based on issues opened.It has been published in Android-arsenal too.

Android Arsenal - https://android-arsenal.com/details/1/3049
<br />
Please Do Contribute and Optimize the code as possible.

##License 
<hr>
The MIT License (MIT)

Copyright (c) Shivasurya S

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
