# gridlib

GridLib is a collection of Java packages with the intent of facilitating different programming tasks. Currently, gridlib consists of four packages:

- gridlib: This library facilitates the creation, organization, iteration, and visualization of data within a grid. Data is held in a `Tile` class, many of which can be organized into a `TileMap` object. The `TileMap` object allows the data to be manipulated in relation to one another. A `TileMapViewer` object can then display the data contained in the `Tile` objects through `Tile.paint(Graphics g)`.  

- loglib: This is a far simpler package. Loglib allows the user to make log messages on the fly, as well as customize how the log messages are handled. Already included in this package are `FileHandler` and `ConsoleHandler`, which outputs the log message to a text file or the console, respectively.  

- guilib: Guilib contains a selection of custom swing components, such as password fields, color palettes, and more.  
 
- colorlib: This is the most recent addition to the project. Colorlib aims to make generating random colors as well as color schemes / palettes a breeze.
