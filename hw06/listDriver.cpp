/****************************************************************************
 *
 * File Name:  listDriver.cpp
 * Course:     CPTR 242
 * Source:     Book Provided Code
 *
 */
// Test driver
#include <cctype>
#include <cstring>
#include <fstream>
#include <iostream>
#include <string>

#include "unsorted.h"

using namespace std;
void PrintList(ofstream &outFile, UnsortedType &list);

int main() {
    ifstream inFile;     // file containing operations
    ofstream outFile;    // file containing output
    string inFileName;   // input file external name
    string outFileName;  // output file external name
    string outputLabel;
    string command;  // operation to be executed

    int number;
    ItemType item;
    UnsortedType list;
    bool found;
    int numCommands;

    // Prompt for file names, read file names, and prepare files
    cout << "Enter name of input command file; press return." << endl;
    cin >> inFileName;
    inFile.open(inFileName.c_str());

    cout << "Enter name of output file; press return." << endl;
    cin >> outFileName;
    outFile.open(outFileName.c_str());

    cout << "Enter name of test run; press return." << endl;
    cin >> outputLabel;

    outFile << outputLabel << endl;
    if (!inFile) {
        cout << "File not found." << endl;
        return 0;
    }

    inFile >> command;

    numCommands = 0;
    while (command != "Quit") {
        cout << command;
        if (command == "Sort") {
            list.SortItems();
            outFile << "Sorted list." << endl;
        } else if (command == "MinItem") {
            item = list.MinItem();
            item.Print(outFile);
            outFile << " is the minimum value." << endl;
        } else if (command == "PutItem") {
            inFile >> number;
            item.Initialize(number);
            list.PutItem(item);
            item.Print(outFile);
            outFile << " was added to the list." << endl;
        } else if (command == "DeleteItem") {
            inFile >> number;
            item.Initialize(number);
            list.DeleteItem(item);
            item.Print(outFile);
            outFile << " was deleted." << endl;
        } else if (command == "GetItem") {
            inFile >> number;
            item.Initialize(number);
            item = list.GetItem(item, found);
            item.Print(outFile);
            if (found)
                outFile << number << " found in list." << endl;
            else
                outFile << number << " not in list." << endl;
        } else if (command == "GetLength")
            outFile << "Length is " << list.GetLength() << endl;
        else if (command == "IsFull")
            if (list.IsFull())
                outFile << "List is full." << endl;
            else
                outFile << "List is not full." << endl;
        else if (command == "MakeEmpty")
            list.MakeEmpty();
        else if (command == "PrintList")
            PrintList(outFile, list);
        else
            outFile << command << " is not a valid command." << endl;
        numCommands++;
        cout << " -- Command number " << numCommands << " completed." << endl;
        inFile >> command;
    };

    cout << "Quit" << endl << "Testing completed." << endl;
    inFile.close();
    outFile.close();
    return 0;
};

void PrintList(ofstream &dataFile, UnsortedType &list) {
    // Pre:  list has been initialized.
    //       dataFile is open for writing.
    // Post: Each component in list has been written to dataFile.
    //       dataFile is still open.
    int length;
    ItemType item;
    dataFile << "PrintList: ";
    list.ResetList();
    length = list.GetLength();
    if (length == 0)
        dataFile << "List is empty.";
    else
        for (int counter = 1; counter <= length; counter++) {
            item = list.GetNextItem();
            item.Print(dataFile);
        }
    dataFile << endl;
}
