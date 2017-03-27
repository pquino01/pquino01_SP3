import collection.mutable._

object NumberPersonalities {

val limit = 100



def isPrime(n: Int): Boolean = {
    if (n <= 1)
      false
    else if (n == 2)
      true
    else
      !(2 to (n - 1)).exists(x => n % x == 0)
}            

def testIsPrime {
	for( num <- 1 until 11){
		if (isPrime(num)){println(s"$num is prime")}
		else {println(s"$num is not prime")}
	}
}  

def isHappy(n: Int): Boolean = {
	var num=n
	var setNums : Set[Int] = Set()
    while(!setNums.contains(num)){
        setNums.add(num);
		var sum =0;
		while(num>0){
			sum+=(num%10)*(num%10);
			num=num/10;
		} 
		num=sum
		if(num==1)
            return true
    }
	return false
}  

def testIsHappy {
	for( number <- 1 until 11){
		if (isHappy(number)){println(s"$number is happy")}
		else {println(s"$number is not happy")}
	}
}   

def isTriangular(n: Int): Boolean = {
	var currentTriNum = 0;
    var num=0
	while (currentTriNum < n){
		currentTriNum =currentTriNum + num; 
		num= num+1; 
	}
	if (currentTriNum != n) 
		return false
	else 
		return true
}

def testIsTriangular {
	for( number <- 1 until 11){
		if (isTriangular(number)){println(s"$number is triangular")}
		else {println(s"$number is not triangular")}
	}
}

def isSquare(n: Int): Boolean = {
	var sqrt = math.sqrt(n)
	if(sqrt*sqrt == n){return true}
    else {return false}
}

def testIsSquare {
	for( number <- 1 until 11){
		if (isSquare(number)){println(s"$number is square")}
		else {println(s"$number is not square")}
	}
}

def isSmug(n: Int): Boolean =  {
	if (n < 2) { return false}
    val res = n - findClosestInferiorSquare(n)
	if (isSquare(res)) true else false
} 

def findClosestInferiorSquare(n: Int): Int = {
	var closestSquare = 1
	var i = 1
	while (i<n){
		if (isSquare(i)){closestSquare=i}
		i+=1
	}
	closestSquare
}

def testIsSmug {
	for( number <- 1 until 11){
		if (isSmug(number)){println(s"$number is smug")}
		else {println(s"$number is not smug")}
	}
}

def isDishonest(n: Int): Boolean = {
    var k = 1
    while (n/k != k && n/k > k ) {
      k += 1
    }
    if (n/k == k && k*k != n) true else false
}

def testIsDishonest {
	for( number <- 1 until 11){
		if (isDishonest(number)){println(s"$number is dishonest")}
		else {println(s"$number is honest")}
	}
}

def isPronic(n: Int): Boolean = {
	var i=0
	while (i<n){
        if(i*(i+1) == n) {return true}
		i+=1
    }
	return false
}

def testIsPronic {
	for( number <- 1 until 11){
		if (isPronic(number)){println(s"$number is pronic")}
		else {println(s"$number is not pronic")}
	}
}

def isDeficient(n: Int): Boolean = {
    sumOfPositiveDivisorsOf(n) < n
}

def isPerfect(n: Int): Boolean = {
    sumOfPositiveDivisorsOf(n) == n
}

def testIsPerfect {
	for( number <- 1 until 11){
		if (isPerfect(number)){println(s"$number is perfect")}
		else {println(s"$number is not perfect")}
	}
}

def isAbundant(n: Int): Boolean = {
   sumOfPositiveDivisorsOf(n) > n
}

def sumOfPositiveDivisorsOf(n:Int): Int = {
    var result = 0
    for ( i <- 1 to n-1 if (n%i==0) ) {
      result += i
    }
    result
}

def main(args: Array[String]): Unit = {
	var print = ""
    var n = 1
    for ( n <- 1 to limit ) {
      print = n + "   "
      if (isPrime(n)) print += "p, " else print += "c, "
      if (isHappy(n)) print += "h, " else print += "u, "
      if (isTriangular(n)) print += "t, " else print +="not t, "
      if (isSquare(n)) print += "s, " else print +="not s, "
      if (isSmug(n)) print += "sm, " else print +="not sm, "
      if (isDishonest(n)) print += "dis, " else print += "ht, "
      if (isPronic(n)) print +="pr, " else print +="not pr, "
      if (isDeficient(n)) print +="d"
      if (isPerfect(n)) print +="per"
      println(print)
    }
}




}                               
