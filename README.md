# MScProjectPrototype01
Prototype 1 for MSc Project

##Introduction
This is the first prototype of a tile matching game that I wil be working on until September 2016 for my 
MSc Computer Science final project. At the moment the code is just in basic Java but it will eventually become
an Android app that helps children with autism to read people's facial expressions, which is something that 
they find difficult.

This early version features 5 emotions representing angry, confused, excited, happy, and sad. These are 
currently represented on a board by their first two letters (i.e AN for angry). The basic idea of the 
game is to make a connection of 3 or more emotions of the same type by swapping ones that are adjacent.
When this is done, those emotions will disappear and the above emotions will drop down accordingly and 
new randomly generated emotions will fill the vacant spaces. 

Once graphics are introduced, children will be able to practice recognizing and differentiating between 
emoticons, and when matching lines are made, each emotion will be emphasized through a combination of 
graphics, sounds, and points.

Ideally, extra functionality will be added to allow parents to choose which emoticons their child will 
play the game with in order to introduce the child to a wider range of emotions. There are a lot of other
ideas I would like to introduce and I will elaborate on these during the duration of my work on the project.

Although it is still in a very primitive stage, thinking through the logic of the game and coding it up in 
Java has been very useful, and made me aware of small details that I had not yet considered. For example, 
after the user selects a tile, if their second choice is the same as the first, the choices should be 
reset. However, if the user's second choice is a tile that is not adjacent to the first but still within
the range of the board) the second choice should become the user's first choice.

##Starting the game
To play the game, run the GameInitializer located in the gameboard package. You will then be given instructions
on how to select a tile.

##Testing
As testing a game that generates its parts at random it not ideal, I have created a MockBoardPopulator01 that 
fills the board with different numbers and then applies the game pieces in such a way that one particular move
in the test will make a match that should give predictable results. 



