
# Content

- Abstract
- Acknowledgment
- Introduction
- project aims & objectives
- Technical overview
- further improvements



# Abstract

Foodie is an application that can use as a toxic percentage meter while shopping packed food items
such as buiscuits. Barcodes attached to packed food contains details such as E numbers for specific
food additives, Calorie and Carbohydrate percentages. Once a list of food we intend to buy is added, Foodie calculate these percentages and compare with recommended optimum levels for human body (already defined in App). After considering previous shopping lists, Foodie recommends how much packets of a specific food product is safe to buy without exceeding the overall toxic percentage for a given time period (for a week/ two weeks).



# Acknowledgment
We would like to express our special thanks to the lecturer incharge of course unit ICT 306 1.5 Mobile Technologies and Application development, Dr. Ravimal Bandara for his time and efforts he provided throughout the semester. Your useful guidance was really helpful to us during the
project's completion.


# Introduction

## ● Background ofthe project

When manufacturing food items in industrial level, adding various kinds of preservatives, additives
is a must to keep the food packed in best condition for a long period of time. These details and
other ingredients of food items and their Calorie, Carbohydrate percentages, Energy, Fat, vitamin
levels are displayed in the package.
As the consumption of some of these substances in larger amounts can cause serious long term
health issues, experts have recommended optimum intake levels for a specific time period (Ex: 1
miligram per day) which aren’t toxic to human body But as customers most of us don’t pay much attention to these details and tend to buy food items
as our preference/ recommandations of others/ attraction of promoting methods of companies.
Sometimes even if we’re aware of harmfulness of this, it’s difficult to calculate these percentage
levels manually and keep records daily. Also there are people who are in special need of these
numbers such as nutricians, sportspersons and people on diets with recommended nutrition
values. This issue created the project background for Foodie.

## ● The rationale of the project

So the lack of an easy-to-use method/ application that gives recommandation which helps user to
reduce overconsumption of toxic ingredients in packed food items before buying them (while
shopping) is the problem we are planing to solve using Foodie.
Foodie comes as an application which user can simply download and install in their android mobile
phone and use while shopping.

# project aims & objectives

● When launched, Foodie should allow user to search(by their names and brand names) , select
and add food items to their list and remove remove already selected ones.
● When a food item list is added by user, Foodie should be able to calculate user’s
consumption of different substances contained in those food items.
● After calculating , the data should be displayed in an understanable manner.
● Suitable warnings, and reminders should be provided to user.

# Technical overview
## ● Real-time database and Recycle view
Firebase database was used for Foodie as it’s a real time cloud based system with fast update of
data according to query changes in higher accuracy compared to other systems such as SQLite.
This real time database is synced with recycle view that support real time search, where the
changes in Jason file (used to save food item data of Foodie) are fetch into app components real time

## ● List view and progress bar

List view is added to show customer the added items and progress bar to show calculated nutrition
values as percentages in user friendly(graphical) ways.

## ● Logo, Color palette and Custom made app icons
A dedicated logo and a loading animation was designed with an idea to build Foodie as brand and a
Yellow-gray colour palette was used.



# Screenshots

![App Screenshot](https://i.ibb.co/PgDWmhY/1.jpg)
![App Screenshot](https://i.ibb.co/NxX9NN2/2.jpg)
![App Screenshot](https://i.ibb.co/NVJX1p7/3.jpg)
![App Screenshot](https://i.ibb.co/rZRZVf2/4.jpg)
![App Screenshot](https://i.ibb.co/fCT2wq4/5.jpg)
![App Screenshot](https://i.ibb.co/2y6Z1T1/6.jpg)
![App Screenshot](https://i.ibb.co/stb96FR/7.jpg)
