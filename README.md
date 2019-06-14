# Bot for game Combats

The game is here: http://www.combats.com/, it is RPG on-line game.

command for launch not compiled from console: <br/>
     * mvn exec:java -Dexec.mainClass="com.combats.GameCombatsBot" ...parameters...
     
command for launch Combats.jar from console: <br/>
     * java ...parameters... -jar Combats-version.jar
     
Parameters:  
 -Dlogin=login  
 -Dpassword=password  
 <--optional-->  
 -DtypeOfGame=chaos/dungeon  
 -Dpet=yes/no  
 -Dheadless=true/false  
 -DtelegramAPI=telegramAPI  
