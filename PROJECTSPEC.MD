PROJECT SPEC DOCUMENT
**Firm Folios**

Table of Contents
App Overview
Product Spec
Wireframes
Build Notes
App Overview
Description
FirmFolios is a mobile application made by students for students transitioning from academia into the professional world. It provides only the most relevent company/firm information that would be useful when looking for a position or preparing for a behavorial inteview for one.

App Evaluation
Category:
Career Services App
Mobile:
The product experience is uniquely mobile because it should be easy to use and only display the most important information of a company that a user might need. It should essentially cut out the “white noise” that other job search/company information applications offer, which often ends up overwelming a user base that might not need all the irrelevant information.
Story:
The origin of this idea lies in the mind-numbing experience that is the internship search. This app should serve as a useful tool to our friends and peers that are also students in college. It’s main goal is to educate and assist students in the transition from academia to the professional sphere. It should therefore be welcomed by those at this similar stage in life.
Market:
While the market for this app, university students, might not be the most unique, it is quite large. University students, typically from the ages of 18 to 22, should find this app useful in their internship and job search.
Habit:
This app, which will be made by students for students, is designed to not be addictive. It’s main goal is to educate and improve productivity. With that said, the average user should open and use this app anytime they come across an internship or job opening from a company they have not heard of. It could also be used as a study guide of sorts right before a behavorial interview, where companies might factor in how much a student knows into their hiring decision. Given that most students need to send out hundreds of applications before landing their first internship or full-time offers, the app should see alot of use.
Scope:
A stripped down version is perfectly buildable by the deadline. It also shouldn’t be too technically challenging given that most team members have some knowledge of Android development even if they are not experts. In addition to this, while a minimum viable product will allow us to demonstrate our proof of concept, the idea allows for further expansion past the deadline for members interested in working on it afterwards.
Product Spec
1. User Features (Required and Optional)
Required Features:

Users can search for a list of companies that match the company name they put in and the country they designate
Stretch Features:

Users can obtain a full company profile for each listed company above from the Orb database, based on the fetch_url key
2. Chosen API(s)
https://api.orb-intelligence.com/3/match/

User can search for a company and get matching results
https://api.orb-intelligence.com/3/match//3/fetch/{orb_num}/

User can get a company profile from the Orb database
3. User Interaction
Required Feature

Get Match: User enters a company name and country
=> Results display a list of matching companies with name (name key), address (address1, city, state, zip keys), and link to a full company profile (fetch_url key)
Wireframes
https://imgur.com/a/UlFO6fE

[BONUS] Digital Wireframes & Mockups
[BONUS] Interactive Prototype
Build Notes
Here’s a place for any other notes on the app, it’s creation
process, or what you learned this unit!
<img src="https://i.postimg.cc/3JSLYZ50/image-123927839-5.jpg" width=600>

For Milestone 2, include 2+ Videos/GIFs of the build process here!
Gif1 - https://imgur.com/a/g8wNcZe
Gif2 - https://imgur.com/a/tD0NvKo

License
Copyright 2023 Pod 33

Licensed under the Apache License, Version 2.0 (the “License”);
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an “AS IS” BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
