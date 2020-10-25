# 2D-Predator-Prey-Simulation
In this project, I created a 2-D Predator Prey simulation form to monitor the steps of flies (Preys) and spiders (Predators). First, I created the grids with the condition that one grid square can hold either one fly or one spider. Then, I created controls (step, fly count, spider count, steps completed, empty space count, initial values, and initialize). After styling the form and setting the size of panels, I looped through array of organisms and represented them as a label. 

1. The Organism class encapsulates common attributes and behaviors of the fly and spider. 
2. The Fly and the Spider class inherits from Organism class and overwrites the breed(), Move(), and starve() methods. 
3. The World class comprises a multi-dimensional array called Organism with grid attribute and represents a collection of animals in space.
4. The Cell class is a visual representation of an Organism on the form

Each critter performs one of the following actions every step:-

1. Move: Every step, a fly can move either one or two cells (up, down, right, or left) and is monitored by the position of spider. If the selected cell is occupied by a spider, the fly makes the move and eats the spider. If the selected cell is occupied by another fly, the fly tries moving to another cell. Every step, a spider can move only one cell (up, down, right, or left) with the same rules as the flies.
2. Breed: At the end of second step, the fly will breed. This is simulated by creating a new fly in an adjacent cell that is empty. If there is no empty cell, no breeding occurs. Once an offspring is produced, the fly cannot produce an offspring until three more steps have elapsed.
3. Starve: At the end of 9 steps, the spider will starve and die and is removed from the cell.



