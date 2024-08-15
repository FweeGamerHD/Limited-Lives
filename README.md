# Limited-Lives
Limited-Lives is a Minecraft Fabric mod that adds a system for a limited amount of respawns and puts players into "permanent" spectator mode once they run out of lives.

## Features
- **Configurable amount** of lives
- **Easy editability** of the amount of lives in-game (changing the numbers for a player)
- **Optional Luckperms integration** to exclude certain players from the system

## Usage

1. **Installation:**
   - Download the latest release JAR file from the [Releases](https://github.com/FweeGamerHD/Limited-Lives/releases) page.
   - Place the downloaded JAR file into the `mods` folder of your Minecraft Fabric server.

2. **Configuration:**
   - After starting the server with the mod installed, a configuration file (`config.json`) will be created in the `config\limitedlives` folder.
   - Edit the configuration file to adjust settings such as the max amount of lives (technically respawns) every player gets and the messages sent in chat to the players.
   - Note: Use %l to display the amount of lives a player has left in the messages.

3. **Operation:**
   - The mod will automatically do its thing once a player dies for the first time. (so no data once someone actually dies first)
   - Players will see their remaining lives in the chat every time they respawn.
   - Once a player runs out of lives, they will be put into spectator mode and will not be able to respawn anymore.

## Contributing
Contributions are welcome! If you'd like to contribute to the development of this mod, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/fooBar`).
3. Commit your changes (`git commit -am 'Add some fooBar'`).
4. Push to the branch (`git push origin feature/fooBar`).
5. Create a new Pull Request.

## License

This mod is licensed under the [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](LICENSE).