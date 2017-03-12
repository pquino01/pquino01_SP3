import scala.util.Random

object Hammurabi {

var starved = 0 // how many people starved
var immigrants = 5 // how many people came to the city
var population = 100
var harvest = 3000 // total bushels harvested
var bushelsPerAcre = 3 // amount harvested for each acre planted
var rats_ate = 200 // bushels destroyed by rats
var bushelsInStorage = 2800
var acresOwned = 1000
var pricePerAcre = 19 // each acre costs this many bushels
var plagueDeaths = 0

def printIntroductoryMessage () {

println("""Congratulations, you are the newest ruler of ancient Samaria, elected
for a ten year term of office. Your duties are to dispense food, direct
farming, and buy and sell land as needed to support your people. Watch
out for rat infestations and the plague! Grain is the general currency,
measured in bushels. The following will help you in your decisions:
* Each person needs at least 20 bushels of grain per year to survive.
* Each person can farm at most 10 acres of land.
* It takes 2 bushels of grain to farm an acre of land.
* The market price for land fluctuates yearly.
Rule wisely and you will be showered with appreciation at the end of
your term. Rule poorly and you will be kicked out of office!""")

}

def hammurabi () {

printIntroductoryMessage()

var year=0
for( year <- 1 until 11){

println(s"""0 great Hammurabi!
You are in year $year of your ten year rule.
In the previous year $starved people starved to death.
In the previous year $immigrants people entered the kingdom.
The population is now $population.
We harvested $harvest bushels at $bushelsPerAcre bushels per acre.
Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.
The city owns $acresOwned acres of land.
Land is currently worth $pricePerAcre bushels per acre.
There were $plagueDeaths deaths from the plague.""")

var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
acresOwned = acresOwned + acresToBuy
bushelsInStorage=bushelsInStorage- (acresToBuy*pricePerAcre)

if (acresToBuy==0) {
var acresToSell = askHowMuchLandToSell(acresOwned, pricePerAcre)
acresOwned = acresOwned - acresToSell
bushelsInStorage=bushelsInStorage+ (acresToSell*pricePerAcre)
}

var bushelsToFeedPeople = askHowMuchGrainToFeedPeople(bushelsInStorage)
bushelsInStorage = bushelsInStorage - bushelsToFeedPeople

var acresToPlantWithSeed = askHowManyAcresToPlantWithSeed(acresOwned)
harvest=acresToPlantWithSeed*bushelsPerAcre


var deaths = populationPossiblePlague (population)
plagueDeaths = plagueDeaths + deaths
population = population - deaths

starved= howManyPeopleStarved (starved,bushelsToFeedPeople, population)
if (starved > 45*(population/100)){
println("O Great Hammurabi, too many people starved. So you are thrown of office and the game is over!")
return //exit the for and end the game
}

var peopleComing = howManyPeopleCameToCity (starved, acresOwned, bushelsInStorage, population)
immigrants= peopleComing
population = population + peopleComing

bushelsPerAcre = howGoodHarvestIs ()
harvest = acresToPlantWithSeed * bushelsPerAcre

rats_ate = possibleProblemRats (harvest: Int)
bushelsInStorage = harvest - rats_ate

pricePerAcre = pricePerAcreNextYear ()

}
println(s"""0 great Hammurabi!
In this game, $starved people starved and you ended up
with $acresOwned acres of Land!.""")
}

def readInt(message: String): Int = {

try {
readLine(message).toInt
} catch {
case _ : Throwable =>
println("That’s not an integer. Please enter an integer.")
readInt(message)
}
}

def askHowMuchLandToBuy(bushels: Int, price: Int) = {
var acresToBuy = readInt("How many acres will you buy? ")
while (acresToBuy < 0 || acresToBuy * price > bushels) {
println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
acresToBuy = readInt("How many acres will you buy? ")
}
acresToBuy
}

def askHowMuchLandToSell(acresOwned: Int, price: Int) = {
var acresToSell = readInt("How many acres will you sell? ")
while (acresToSell < 0 || acresToSell > acresOwned) {
println("O Great Hammurabi, we have but " + acresOwned + " acres of land!")
acresToSell = readInt("How many acres will you sell? ")
}
acresToSell
}

def askHowMuchGrainToFeedPeople(bushelsInStorage: Int) = {
var bushelsToFeedPeople = readInt("How many bushels of grain to feed people? ")
while (bushelsToFeedPeople < 0 || bushelsToFeedPeople > bushelsInStorage) {
println("O Great Hammurabi, we have but " + bushelsInStorage + " bushels in storage to feed people!")
bushelsToFeedPeople = readInt("How many bushels of grain to feed people? ")
}
bushelsToFeedPeople
}

def askHowManyAcresToPlantWithSeed(acresOwned: Int) = {
var acresToPlantWithSeed = readInt("How many acres to plant with seed? ")
while (acresToPlantWithSeed < 0 || acresToPlantWithSeed > acresOwned) {
println("O Great Hammurabi, we have but " + acresOwned + " acres of land!")
acresToPlantWithSeed = readInt("How many acres to plant with seed? ")
}
acresToPlantWithSeed
}

def populationPossiblePlague (population: Int) = {
var deaths = 0
//plague takes places at 15% chance
if (Random.nextInt(100) < 15) {
deaths = population/2
}
deaths 
}

def howManyPeopleStarved (starved: Int,bushelsToFeedPeople: Int, population: Int) = {
var starvedPeople = population - (bushelsToFeedPeople/20)
if (starvedPeople<0){starvedPeople=0}
starvedPeople}

def howManyPeopleCameToCity (starved: Int, acresOwned: Int,bushelsInStorage: Int, population: Int) = {
var peopleComing=0
if (starved==0){
peopleComing= (20 * acresOwned + bushelsInStorage) / (100 * population) + 1
}
peopleComing
}

def howGoodHarvestIs () = {
var bushelsPerAcreRandomlyGenerated = Random.nextInt(8)+1 
bushelsPerAcreRandomlyGenerated
}

def possibleProblemRats (harvest: Int) = {
var RandomRats_ate=0
//rat insfestation 40% chance
if (Random.nextInt(100) < 40) {
RandomRats_ate = (harvest/10) * Random.nextInt(3)+1
}
RandomRats_ate
}

def pricePerAcreNextYear () = {
var price = Random.nextInt(23)+17 
price
}

}
Hammurabi.hammurabi