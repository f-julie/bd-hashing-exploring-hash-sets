# [TEAM NAME] Exploring `HashSet`s GILA

## GILA Roles

This activity will explore how to utilize Java arrays to simultaneously eliminate duplicates and reduce the runtime
complexity of adding, removing, and searching for elements in the array to constant, O(1), time typically.
  
Before you start, complete the form below to assign a role to each member.
  
If you have 3 people, combine the Presenter and Reflector.

| Team                               | Date                |
|:-----------------------------------|:--------------------|
| &nbsp;                             | &nbsp;              |

&nbsp;

| Team Roles                         | Team Member         |
|:-----------------------------------|:--------------------|
| **Recorder**: records all answers and questions, provides copies to team and facilitator. |                     |
| **Presenter**: talks to facilitator and other teams. |                     |
| **Manager**: keeps track of time and makes sure everyone contributes appropriately. |                     |
| **Reflector**: considers how the team could work and learn more effectively. |                     |
 
## PART A - `DevicePart`s

|                                      | Start time: |
|:-------------------------------------|:------------|
| **(25 minutes) A. `DevicePart`s**    |             |

Amazon doesn’t own any manufacturing facilities, so we have contracts with other companies to build our Kindles, Echos,
and other devices. In some cases, the manufacturer provides the parts needed; in most cases, we purchase the parts from
a “supplier” ourselves and send them to the manufacturer.

A General Part Manager (GPM) is the Amazonian responsible for negotiating contracts with suppliers for the parts
used in Amazon devices, e.g. the Echo Show, the Fire TV Stick, and the Kindle Paperwhite. Our engineering team supports
the GPMs and helps each GPM keep track of the device parts they own. We will need to ensure that a GPM isn’t trying to
manage duplicate devices, add device parts for a GPM to manage, and check if a GPM manages a specific part.

The GPM who manages microphones across Amazon devices has offered to act as our test case. An example device part that
this GPM manages is a "Knowles" microphone. The manufacturer's part number for this microphone is "SPH0655LM4H-1". This
microphone is used in both the Echo Auto and Echo Loop.

Open the `DevicePart` class in the `com.amazon.ata.hashingset.partsmanager` package. Refer to the code in
this class to answer the following questions:

1. What instance variables does `DevicePart` have?



2. Could this class currently be used in a `HashSet`? Should it? Why or why not?




3. What does your team think makes a `DevicePart` unique? 



4. What instance variables should be used to implement `hashCode()`?



5. Do any other methods need to be implemented? Should any of the instance variables be used in that method?



6. Individually implement the missing methods in the `DevicePart` class in your Snippets package. You can
test these methods by running the `DevicePart` test class. When your tests are passing, check the box
next to your role. Check with your group and see if anyone needs help.

[] Recorder

[] Presenter

[] Manager

[] Reflector

## PART B - Relating hash code value to index

|                                                      | Start time: |
|:-----------------------------------------------------|:------------|
| **(8 minutes) B. Relating hash code value to index** |             |

```
5 % 10 = 5
12 % 10 = 2
103 % 10 = 3
7560 % 10 = 0
```
*Model 1. A few math calculations.*

1. What symbols are being used in each each equation in *Model 1*?



2. What is the second number in each equation in *Model 1*?



3. How does the first number and the number on the right side of the equals sign relate in each equation?






## PART C - Adding to a `HashSet`

|                                         | Start time: |
|:----------------------------------------|:------------|
| **(25 minutes) C. Adding to a HashSet** |             |

The GPM who manages all of the microphone device parts has sent us over the manufacturer, manufacturer part number, and
the list of devices each part is used in for every microphone they own. These are the items we will want to add to our
`HashSet`. Here are the microphone objects we will be working with and their hash code values:

```
DevicePart flex = new DevicePart("Knowles", "KAS-700-0147",
    Arrays.asList(AmazonDevice.FIRE_TV_STICK, AmazonDevice.FIRE_TV_STICK_4K, AmazonDevice.ECHO_BUDS));
System.out.println(flex.hashCode()); // 118352462

DevicePart button = new DevicePart("CUI Devices", "CMEJ-04150420P",
    Arrays.asList(AmazonDevice.ECHO_PLUS));
System.out.println(button.hashCode()); // 865113938

DevicePart omnidirectional = new DevicePart("Knowles", "FG-23329-P142",
    Arrays.asList(AmazonDevice.ECHO_PLUS));
System.out.println(omnidirectional.hashCode()); // 1442407170

DevicePart noiseCancelling = new DevicePart("Knowles", "FB-EM-30342-000",
    Arrays.asList(AmazonDevice.ECHO_BUDS));
System.out.println(noiseCancelling.hashCode()); // 1975012498

DevicePart cuiDevice = new DevicePart("CUI Devices", "CMEJ-04150420P",
    Arrays.asList(AmazonDevice.ECHO_PLUS));
System.out.println(cuiDevice.hashCode()); // 865113938

DevicePart wired = new DevicePart("Knowles", "VFG-30747-000",
    Arrays.asList(AmazonDevice.FIRE_7_KIDS_EDITION, AmazonDevice.FIRE_HD_8_KIDS_EDITION, AmazonDevice.FIRE_HD_10_KIDS_EDITION));
System.out.println(wired.hashCode()); // 118352462

DevicePart cord = new DevicePart("CUI Devices", "CMEJ-4622-25-L082",
    Arrays.asList(AmazonDevice.ECHO));
System.out.println(cord.hashCode()); // 1550089733

DevicePart grounded = new DevicePart("Knowles", "EK-26899-P03",
    Arrays.asList(AmazonDevice.ECHO_FRAMES));
System.out.println(grounded.hashCode()); // 1118140812

DevicePart puiAudio = new DevicePart("PUI Audio", "AMM-2738B-R",
    Arrays.asList(AmazonDevice.ECHO_DOT, AmazonDevice.ECHO_SHOW_5, AmazonDevice.ECHO_SHOW_8));
System.out.println(puiAudio.hashCode()); // 1311053138
```
*Code Block 1. Each microphone object we will be working with and their hashcode values.*


The `%` symbol from part B is called the **modulo** operator.
It calculates the remainder of the first number when it is divided by the
second number. You don't need to remember how to calculate remainders at this moment. We will be using the modulo
operator to convert our hash code value into an array index. We will be working with an array of size 10. So the second
number in our modulo equation will always be 10. When we take any number modulo 10, the digit in the ones place of the
number is always returned. For example, `456 % 10 = 6`. That means the numbers 0 - 9 are the only numbers that can be
returned when we modulo our hash code value by 10. This will align perfectly with the indexes in our size 10 array.
A common strategy in converting hash code numbers to indexes is to modulo by the size of the array. The result will
always be an index of the array.

1. Take a look at the `PartManager` class in the `com.amazon.ata.hashingset.partsmanager` Java package and
   execute code block 2 below to fill in the following tables. You’ll want to update both tables after each new line in
   the code block 2.
   
   In *Table 1*, you will record some statistics about each executed line of code. **For each call to `addDevicePart()`
   we suggest filling in both *Table 1* and *Table 2* before moving on to the next call to `addDevicePart()`.**
   We recommend bolding each line of code as you go to help you keep your place.
   
   *Table 2* represents the underlying storage array of the `HashSet` inside the `PartManager` class.
   Each index is represented by a column with its index number at the top. In this question you will be adding
   `DevicePart`s to a `HashSet`. For each add, you'll add the `DevicePart`'s variable name to the index column
   you determine it belongs in.

   We've gone ahead and executed the call to `addDevicePart()` on line 2 of *Code Block 2* for you as an example.
   On line 2 `flex` is the parameter to the `add` method called on the `deviceParts` `HashSet` in the
   `PartManager` class. Column 2 is asking for the number of hash codes that were calculated in this
   line's call to `add`. When we `add` `flex`, we need to calculate the hashcode just once for that object. We look up
   at *Code Block 1* to determine what the hash value for the flex object should be. Using modulo 10, we can then
   convert this into an index. At this point we went ahead and looked at *Table 2.* What was already in that index, did
   we need to compare anything? Not here. Then we update *Table 2* with the location of the `flex` object. At this point
   we update *Table 1* with the value of `isAdded` for `flex` on line 2 and the current size of the `deviceParts`
   `HashSet`.
   
   ```
   1: PartManager microphonePartManager = new PartManager();
   2: microphonePartManager.addDevicePart(flex);
   3: microphonePartManager.addDevicePart(button);
   4: microphonePartManager.addDevicePart(omnidirectional);
   5: microphonePartManager.addDevicePart(noiseCancelling);
   6: microphonePartManager.addDevicePart(cuiDevice);
   7: microphonePartManager.addDevicePart(wired);
   ```
   
   *Code Block 2. Adding device to our team's device set.*

   | Parameter to `add` | # hashes calculated | Hash value | Index calculated | # device parts compared | Return value from `add` | `deviceParts.size()` |
   |-------------------:|---------------------|------------|------------------|-------------------------|-------------------------|----------------------|
   | flex               |          1          | 118352462  |        2         |          0              |          true           |        1             |
   |                    |                     |            |                  |                         |                         |                      |
   |                    |                     |            |                  |                         |                         |                      |
   |                    |                     |            |                  |                         |                         |                      |
   |                    |                     |            |                  |                         |                         |                      |
   |                    |                     |            |                  |                         |                         |                      |
   
   *Table 1. Statistics related to adding items to our `HashSet`* 
       
    | 0 | 1 | 2    | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    |---|---|------|---|---|---|---|---|---|---|
    |   |   | flex |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |

   *Table 2. Each column represents an index in an array.*
     

2. Is there a relationship between the number of times `hashCode` was called and `equals` was called?

3. Which `DevicePart` variables had the same hash code values?

4. In what situation do we experience the *worst case* runtime complexity for adding an element to a HashSet?

5. In what situation do we experience the *best case* runtime complexity of adding an element to a HashSet?

6. What is the *average* runtime complexity of adding an element to a `HashSet`? What is the *worst case* runtime
   complexity?

7. Is the size of a `HashSet` the same as its array's size? What defines a `HashSet`'s size?

8. Our `hashcode()` method returned the same value for the `wired` microphone and the `flex` microphone. Is our
   `hashcode()` method working correctly? Why do we allow this?




### Extensions
  Done early? Consider these questions:
  
  1. When we added the `cuiDevice`, our `equals` method told us it was identical to one of the device parts already in the
     collection, so we didn't add it. Suppose that `DevicePart` implemented `hashCode()`, but didn't implement `equals`.
     
     a. Which `equals` method would have been used?
     
     
     
     b. Would the `cuiDevice` have been added to the `HashSet`?
     
     
     
     c. What would qualify as a duplicate if `equals` wasn't overwritten?
  
  

  2. Suppose that `hashCode()` considered the devices a `DevicePart` was used in, while `equals` did not. What would
     happen if `cuiDevice` was used in different devices than `button`?
     
     
     a. What problems could this cause?
     
     
     
     
  3. Suppose that we implemented `equals()`, but used the `hashCode()` we inherited from `Object`. Where would
     `cuiDevice` be indexed?
     
     
     
     
     a. What problems could this cause?




## PART D - Iterating over a HashSet

|                                       | Start time: |
|:--------------------------------------|:------------|
| **(15 minutes) D. Iterating**         |             |


Let's try listing the contents of our `HashSet`.

Here is a copy of your table 2 array representation.

    | 0 | 1 | 2    | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    |---|---|------|---|---|---|---|---|---|---|
    |   |   | flex |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |

   *Table 3. A copy of the HashSet's internal representation.*
   
   
   

1. What is a possible output of the `printDeviceParts` method in `PartManager` if the `deviceParts` contents matches
   table 2?
   
   
   

   
2. What is the runtime complexity of listing the contents of a `HashSet`?





3. How does this compare to the runtime of listing the contents of an `ArrayList`?





4. Did you list the device parts in the same order they were added?







5. Does iterating over the `HashSet` require calling the `DevicePart` class' `hashCode()`? How about `equals`?






## PART E - `HashSet` contains

|                               | Start time: |
|:------------------------------|:------------|
| **(15 minutes) E. Contains**  |             |

1. Describe the algorithm you think `HashSet` uses to determine whether it contains a provided item or not. Here is the
JavaDoc for `contains` method in the `Set` interface:

> Returns true if this set contains the specified element. More formally, returns true if and only if this set contains
> an element e such that if (other == null) { return this == null } else { return  object.equals(this) }.





Here is a copy of your table 2 array representation.
    
    | 0 | 1 | 2    | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    |---|---|------|---|---|---|---|---|---|---|
    |   |   | flex |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
   
   *Table 4. A copy of the HashSet's internal representation.*
   
   

2. What is the typical runtime complexity of finding an element in a `HashSet`?




3. What is the worst-case runtime complexity of finding an element in a `HashSet`?





4. How does this compare to finding an element in an `ArrayList`?





### Extensions
Done early? Consider these questions:

1. The `add` method can also tell you if a `HashSet` already contains an element. Imagine a scenario where you would
   want to use that functionality of `add` and one where you would explicitly want to call `contains()`?






2. Describe how you think `HashSet` removes an element.





   
3. Execute this code snippet and complete the following tables. *Table 6* contains statistics on removing elements.
   *Table 7* is a copy of your original internal representation of the array. Edit table 7 to reflect the changes made
   by the `activityD` method.

    ```
    public void activityD(HashSet<DevicePart> deviceParts) {
        deviceParts.remove(omnidirectional);
        deviceParts.remove(cord);
        deviceParts.remove(grounded);
        deviceParts.remove(button);
        deviceParts.remove(puiAudio);
    }
    ```

   | Parameter to `remove` | Index | # Hashes Calculated | # Devices Compared | Result of call to remove |
   |----------------------:|-------|---------------------|--------------------|--------------------------|
   |                       |       |                     |                    |                          |
   |                       |       |                     |                    |                          |
   |                       |       |                     |                    |                          |
   |                       |       |                     |                    |                          |
   |                       |       |                     |                    |                          |
   
    *Table 6. Statistics about removing items from the HashSet*
   
    | 0 | 1 | 2    | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
    |---|---|------|---|---|---|---|---|---|---|
    |   |   | flex |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
    |   |   |      |   |   |   |   |   |   |   |
   

   *Table 7. A copy of the HashSet's internal representation.*

4. What is the runtime complexity of removing an element from a `HashSet`?





5. What qualities would you want in a hashing algorithm to avoid the worst case complexities?




6. If our array was not 10 elements long, how would our hashing algorithm change?






7. If we discovered that a hashing algorithm was putting many elements in the same bin, could we change the worst
   case complexities by expanding our array and reinserting the elements?




