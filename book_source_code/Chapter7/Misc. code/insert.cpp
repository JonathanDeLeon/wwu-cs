// insert.cpp
// recursive insertion of item into a linked list

template <class ItemType>
void Insert(NodeType<ItemType>*& listPtr, ItemType item) {
    if (listPtr == NULL || item < listPtr->info) {
        // Save current pointer.
        NodeType<ItemType>* tempPtr = listPtr;
        // Get a new node.
        listPtr = new NodeType<ItemType>;
        listPtr->info = item;
        listPtr->next = tempPtr;
    } else
        Insert(listPtr->next, item);
}
