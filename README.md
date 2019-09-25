# Pacman
This project was to create the game Pacman. It consists of a grid and is filled with food, walls, monsters and pacman himself. The goal of the game is to eat all the food without being eaten by the monsters.

## Controls
Pacman is controled using the W, A, S and D keys. The game can be exited at anytime with CTRL C.

## Symbols
- Pacman = 'v', '^', '<', '>' (open side is direction facing)
- Monster = 'M'
- Wall = '='
- Food = '.'

## Rules
- The grid wraps around so pacman or monsters are able to move from the right most position to the left most position and vice versa, the same is true for up and down.
- Pacman and Monsters can't move onto walls and will stay in place until their direction is changed to avoid the wall.
- Only Pacman can eat food.
- Game ends when all food has been eaten or Pacman is eaten by a monster.
