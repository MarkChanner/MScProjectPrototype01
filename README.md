# MScProjectPrototype01
Prototype 1 for MSc Project (Java version)

##Introduction
This is the first prototype of a tile matching game that I wil be working on until September 2016 for my   
MSc Computer Science final project. The code is currently just in basic Java, but it will eventually become  
an Android app that helps children with an autism spectrum condition (ASD) to read people's facial expressions,  
which is something that some people with ASD sometimes find difficult.  
  
This early version features 5 emotions representing angry, embarrassed, happy, sad, and surprised. These are 
currently represented on a board by their first two letters (i.e AN for angry). The basic idea of the 
game is to make a connection of 3 or more emoticons of the same type by swapping those that are adjacent.
When this is done, those emoticons will be removed and the above emoticonss will drop down accordingly, then 
new randomly generated emoticons will fill the vacant spaces. 

Once graphics are introduced, children will be able to practice recognizing and differentiating between 
emotions, and when matching lines are made, each emotion will be emphasized through a combination of 
graphics, sounds, and points.

##Starting the game
To play the game, run the GameInitializer located in the controller package. You will then be given instructions
on how to select a tile.

##Testing
As testing a game that generates its parts at random it not ideal, a MockBoardPopulator01 has been created that 
fills the board with different numbers and then applies the game pieces in such a way that one particular move
in the test will make a match that gives predictable results. 



