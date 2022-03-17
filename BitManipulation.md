
# Bit Manipulation

## Bitwise Operators

- `&`: AND
- `|`: OR
- `^`: XOR
- `~`: NOT
- `<<`: Binary Left Shift  --is the left shift operator and meets both logical and arithmetic shifts’ needs.
- `>>`: Binary Right Shift  --is the arithmetic (or signed) right shift operator.      ```10110101>>1 = 11011010```
- `>>>`: Zero Fill Right Shift  --Logical/unsigned right shift is the logical (or unsigned) right shift operator.  ```10110101>>>1 = 01011010```

#### NOTE : In Java, all integer data types are signed and `<<` and `>>` are solely arithmetic shifts.

## Bit Facts

```
  x ^ 0 = x      x & 0 = 0      x | 0 = x
  x ^ 1 = ~x     x & 1 = x      x | 1 = 1
  x ^ x = 0      x & x = x      x | x = x
 ```

## Two's Complement

- Computers typically store integers in two's complement representation.
- Range of unsigned numbers that can be stored with `N` bits is `0` - `+(2^N - 1)`.
- Range of signed numbers that can be stored with `N` bits in two's complement representation is `-(2^(N - 1))` - `+(2^(N - 1) - 1)`.
- Binary representation of `-K` is `concat(1, bin(2^(N - 1) - K))`. Another way to compute it is to flip the bits of the binary representation of `K`, add `1` and then prepend the sign bit `1`.

## Bit Manipulation Questions : 

#### 1) check i<sup>th</sup> bit is set or not :

```
boolean getBit(int num, int i) {
    return ((num & (1 << i)) != 0);
}
// Example : 11 - 1011
   2nd bit :  1011
            & 0010
            -------
              0010
```

#### 2)  Set i<sup>th</sup> Bit :

```
int setBit(int num, int i) {
    return num | (1 << i);
}
```

#### 3) Clear Bit(s)

```
int clearBit(int num, int i) {
    return num & ~(1 << i);
}

int clearBitsMSBThroughI(int num, int i) {
    int mask = (1 << i) - 1;
    return num & mask;
}
// Example : num =20 , i =4
       mask : 3
      ans : 20 & 3 = 0
      
int clearBitsIThrough0(int num, int i) {
    int mask = (-1 << (i + 1));
    return num & mask;
}

// Example : num = 20 , i = 2
       mask : -8
      ans : 20 & -8 = 16
```

#### 4) Toggle Bit

```
// using mask with xor property.

int toggleBit(int num, int i) {
    return num ^ (1 << i);
}
```

#### 5) Update Bit

```
int updateBit(int num, int i, boolean setBit) {
    int value = setBit ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
}

//Example : num = 15 , i = 3, setBit = true
    value : 1
    mask : -9
    ans : 15
```

#### 6) Multiply/Divide by 2<sup>n</sup>

```
num = num << n;   // multiply 
num = num >> n;   // divide
```

#### 7) Check if a number is even

```
return (x & 1 ) == 0
```

#### 8) Convert characters to uppercase or lowercase
```
static String toggleCase(char[] a) 
    { 
        for (int i=0; i<a.length; i++) { 
        
            // Bitwise XOR with 32 
            a[i]^=32; 
        } 
        return new String(a); 
    } 

```

#### 9) Count set bits :
```
 static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

// Example : 11 - 3 set bits
```
#### 10) Swap two values :
```
  a = a ^ b ^ (b = a)
```

#### 11) Take 3 integers and use the lowest number of flips to make the sum of the first two numbers equal to the third :
```
  static int noOfFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitC = ((c >> i) & 1);
            int bitA = ((a >> i) & 1);
            int bitB = ((b >> i) & 1);
 
            if ((bitA | bitB) != bitC) {
                ans += (bitC == 0) ? (bitA == 1 && bitB == 1) ? 2 : 1 : 1;
            }
        }
        return ans;
    }
```

#### 12) Find the element in an array that is not repeated :

```
 static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
    
  - If we take XOR of zero and some bit, it will return that bit: a ^ 0 = a
  - If we take XOR of two same bits, it will return 0: a ^ a = 0
  - For n numbers, the below math can be applied: a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
```

#### 13) Given an integer, find the position of the first set-bit (1) from the right :
```
private static int firstSetBitPosition(int n) {
        if (n == 0) {
            return 0;
        }
 
        int k = 1;
 
        while (true) {
            if ((n & (1 << (k - 1))) == 0) {
                k++;
            } else {
                return k;
            }
        }
    }
    
//if the rightmost significant bit is the set bet using bit & 1. If not, we keep shifting left and checking until we find the bit that makes our AND operation yield 1.
```
