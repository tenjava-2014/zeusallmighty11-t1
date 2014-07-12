zeusallmighty11's ten.java submission
==============================

[![ten.java](https://cdn.mediacru.sh/hu4CJqRD7AiB.svg)](https://tenjava.com/)

This is a submission for the 2014 ten.java contest.

- __Theme:__ Improved Transportation / Travel
- __Time:__ Time 1 (7/12/2014 00:00 to 7/12/2014 10:00 UTC)
- __MC Version:__ 1.7.9 (latest Bukkit beta)
- __Stream URL:__ https://twitch.tv/zeusallmighty11

<!-- put chosen theme above -->

---------------------------------------

Compilation
-----------

- Download & Install [Maven 3](http://maven.apache.org/download.html)
- Clone the repository: `git clone https://github.com/tenjava/zeusallmighty11-t1`
- Compile and create the plugin package using Maven: `mvn`

Maven will download all required dependencies and build a ready-for-use plugin package!

---------------------------------------

Usage
-----

1. Install plugin
2. Do things with it


---------------------------------------


This plugin is 'FancyTransit'. It adds new and improved elements to the current transportation systems in Minecraft.


Minecart Rails:
- Activator rails can now be used to make Minecarts 'bounce' or 'however.

Tutorial:
- Place an activator rail
- 2 Under the activator rail block, place a sign with this:
[Transit]
<jump/hover>
<amount>
<connect>

The second line indicates whether it is 'jump' or 'hover'. So put 'jump' or 'hover'.
The third line indicates the amount of power to apply. Smaller amounts generally work better, but when doing a hover use a large number like 4 or 5.
The fourth and final line indicates whether or not the Minecart should attempt to connect to rails after being airborne.


Boats:
- Obsidian boats can be crafted and can float on lava like in water
Recipe is the same as a boat, but replaced wooden planks with obsidian.


Boots:
- Rocket boots can be crafted with leather boots and 3 feathers to give the user the ability to fly around as long as the boots are on
