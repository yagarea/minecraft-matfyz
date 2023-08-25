# How to setup paperMC server with mffcraftplugin

## 1. Setup paperMC server

First you have to create directory, where do you want your server files to be located.
You can create directory using `mkdir` command. Then go to that directory using `cd` command.

```bash
mkdir mffcraft-server
cd mffcraft-server
```

Then download latest paperMC server using this commnad:

```bash
wget https://api.papermc.io/v2/projects/paper/versions/1.20.1/builds/163/downloads/paper-1.20.1-163.jar
```

After download is complete create `start.sh` script using this command:

```bash
echo -e "#/sbin/bash\n\n/usr/bin/java -Xms1G -Xmx4G -jar ./paper-1.20.1-163.jar --max-players 5 --nogui" > start.sh && chmod +x start.sh
```

Then you can run start script:

```bash
./start.sh
```

When you run it you will be grated with this error:

> ```
> Starting org.bukkit.craftbukkit.Main
> System Info: Java 17 (OpenJDK 64-Bit Server VM 17.0.8.1+1) Host: Linux 6.4.12-arch1-1 (amd64)
> Loading libraries, please wait...
> [18:10:40 INFO]: You need to agree to the EULA in order to run the server. Go to eula.txt for more info.
> ```

Then you should read [minecraft AULA](https://www.minecraft.net/en-us/eula). If you want to accept these terms
run this command:

```bash
echo "eula=true" > eula.txt
```

Now run `./start.sh` again nad your server is running nad ready for players.


## 2. Setuping MFF craft plugin
Go to directory with your server files. There you will find `server.properties`.
Open it in your favourite editor and set property `white-list` to `true`.

Or run this command:

```bash
sed -i 's/white-list=false/white-list=true/g' server.properties
```

Now when someone will try to join server will be greated with this message:

![not white listed](https://github.com/yagarea/minecraft-matfyz/blob/master/docs/not-white-listed.png?raw=true)

This expected behavior because whitelist is enabled and no players are whitelisted yet.

Now run mff craft app:

```bash
java -jar <jarfile> <address> <port> <userDatabase> <whiteListFile>
```

where:
- `<jarfile>` - your built mffcraft app
- `<address>` - you want to mff craft run on
- `<port>` - port on which mffcraft will run
- `<whitelistFile>` - path to `whitelist.json` in your directory with server files

This is all you need to do to make it work.

