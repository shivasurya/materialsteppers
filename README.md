# material design Steppers 
#### Google Material Design Steppers Component  - Android Java - <a href="https://www.google.co.in/design/spec/components/steppers.html">Official Link</a>
#####Steps to Add To your Project :  [ ![Download](https://api.bintray.com/packages/shivasurya/materialsteppers/materialstepper/images/download.svg) ](https://bintray.com/shivasurya/materialsteppers/materialstepper/_latestVersion)
<br>
1) Download the library (i have added to jcenter and waiting for approval) or add in your libs folder <br>
2) Extend your Activity -> from <b>mobileStepperSimple</b> Class <br>
3) Implement the Methods <b>initApp</b> and <b>onStepperCompleted</b><br>
4) Basically Every Steps will be Fragments and will be handling UserInteraction,so create,Extend your fragments from <b>stepperFragment</b> <br>
5) Implement the Method <b>onNextButtonHandler</b> which should return true/false to determine the Library to Move Ahead for next Step,So write your UI validations here and return appropriately.<br>
6) on userActivity create Objects for your fragments made with <b>stepperFragment</b> ,create as many fragments for your use <br>
7) Create <b>List<stepperFragment></b> and add all the object of fragments.<br/>
8) inside your <b>initApp</b> overriden Method, just <b>setFragments(PASS_LIST_OF_FRAGMENTS)</b> <br>
9) finally call <b>init() </b> method from your initApp() method <br>
10) Use <b>onStepperCompleted() </b> for taking actions after the Stepper fragments are completely done by the user <br>

<hr>
<b>Note : with the given List size : step count will be Computed and Updated,Increasing and dynamic fragment feature will be added in future Commits,<br>
Scrollview have been adopted for fragment inbuilt to scroll,So no worries for small screens and large layout.</b>
##DEMO : 
Included the Example Demo app in <a href="https://github.com/shivasurya/materialsteppers/tree/master/example">example project</a>,Download and Sync with gradle.build <br>
<b>Screenshot : </b>
<hr>
<img src="https://raw.githubusercontent.com/shivasurya/materialsteppers/master/screenshot/sample.gif" alt="demo screenshot">
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
i have been developing apps for more than a year,recently working for medical related app which deals with the Collecting Patient Details.since plain Intent based and Activity Fragment will be Monotonous for End user,i searched for Design library and came across the Stepper component and till Date no one have implemented yet,so i managed to release my First version of simple Mobile Stepper Library will be helpful others.
<br />
Please Do Contribute and Optimize the code as possible.

##License 
<hr>
Feel free to use the Library.
