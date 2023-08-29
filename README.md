# ![MFFCraft logo](https://github.com/yagarea/minecraft-matfyz/blob/master/docs/logo.png?raw=true)

Plugin for [CAS](https://cas.cuni.cz/) authentication on school minecraft server.
This can be used to manage access of players automatically.

**How it works ?**  
This is simple web application running independently on minecraft server it self.
When opened users will be greeted by front page with login options.
After user authenticate him self and proof that he is forwarded to form where he can whitelist his in game nickname.
Nickname is written to games whitelist file with all additional information game needs.

This is achieved throw modifying `whitelist.json` of server. Server reads this file every time someone tries to log in.

## [Setup guide](https://github.com/yagarea/minecraft-matfyz/blob/master/docs/setup.md) | [Usage guide](https://github.com/yagarea/minecraft-matfyz/blob/master/docs/usage.md)

## Technical specification

**Used libraries**  
- [Cas client](https://github.com/apereo/java-cas-client) - for CAS protocol
- [JTE](https://jte.gg/) - web templating
- [Javalin](https://javalin.io/) - web framework

[Maven](https://maven.apache.org/) is used as dependency management.

**Usage**  
run `Main.java` with arguments:
```
address port userDatabase whitelistPath
```
where:
- _address_ - address of server running this program (default: `127.0.0.1`)
- _port_ - port (default: `8080`)
- _userDatabase_ - text file containing list of credentials for native users (format `userName:sha256ofPassword`)(default: `src/static/users`)
- _whitelistPath_ - path to minecraft whitelist.json file (default: `src/static/whitelist.json`)

**Authentication methods**  
- **CAS** - not implemented yet because school admin team needs to whitelist this app, so is can use CAS API
- **Native** - this app contains custom autonomous login mechanism (default path of `userDatabse` leads to file with user `admin` with password `heslo`)

**License**  
Published under GPLv3.

