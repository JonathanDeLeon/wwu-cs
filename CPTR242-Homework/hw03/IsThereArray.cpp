/*************************************************************************
 *
 * hw02: Implement IsThere() for Array and Linked implementations
 * 
 * File Name:   IsThereArray.cpp
 * Name:        ?
 * Course:      CPTR 242
 * Date:        ?
 * Time Taken:  ?
 * 
 */
#include "ItemType.h"
#include "SortedArray.h"

// Boolean IsThere(ItemType item)
//  Function:	    Determines if item is in the list.
//  Precondition:	List has been initialized.
// 	Postcondition:	Function value = there exist an item in the list whose key is the same as item's.	
bool SortedArray::IsThere(ItemType item) const {
    
        // TODO Implement the Array version of IsThere() using binary search.
    int mid;
    int lo = 0;
    int hi = length - 1;
    while (lo <= hi) {
        mid = ((unsigned int)lo + (unsigned int)hi) >> 1;
        switch (item.ComparedTo(info[mid])) {
            case LESS:
                hi = mid - 1;
                break;
            case GREATER:
                lo = mid + 1;
                break;
            case EQUAL:
                return true;
        }
    }
    
    return false;
}