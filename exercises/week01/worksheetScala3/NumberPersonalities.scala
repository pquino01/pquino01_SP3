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




}                               
