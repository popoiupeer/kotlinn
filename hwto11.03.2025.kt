#include<iostream>
using namespace std;

template <typename T>
class LinkedList {
public:
    // Класс для узла списка
    class Node {
    public:
        T data;
        Node* next;

        Node() { this->data = 0; this->next = nullptr; }

        Node(T value) { this->data = value; this->next = nullptr; }
    };

    Node* Head;

    LinkedList() { this->Head = nullptr; }
    LinkedList(Node* head) { this->Head = head; }

    void push(T value) {
        if (Head == nullptr) {
            Head = new Node(value);
        }
        else {
            Node* current = Head;

            while (current->next != nullptr) {
                current = current->next;
            }
            current->next = new Node(value);
        }
    }
    void print() {
        if (Head == nullptr) {
            cout << "Список пустой";
        }
        else {
            Node* current = Head;

            while (current->next != nullptr) {
                cout << current->data << " ";
                current = current->next;
            }
            cout << current->data << " ";
            cout << endl;
        }
    }
    T get(int index) {
        if (Head == nullptr) {
            return 0;
        }
        else {
            Node* current = Head;

            while (current->next != nullptr && index > 0) {
                current = current->next;
                index--;
            }
            return current->data;
        }
    }
    void remove(T data) {
        Node* current = Head;

        while (current->next != nullptr && current->data != data) {
            current = current->next;
        }
    }
  
    void removeAt(int index) {

        Node* current = Head;

        while (current->next != nullptr && index > 1) {
            current = current->next;
            index--;
        }
        Node* buffer = current->next->next;
        delete current->next;
        current->next = buffer;
    }
    friend istream& operator>>(istream& in, LinkedList<T>& l) {
        T data;
        while (in >> data) {
            Node* newNode = new Node(data);
            if (l.Head == nullptr) {
                l.Head = newNode;
            }
            else {
                Node* current = l.Head;
                while (current->next != nullptr) {
                    current = current->next;
                }
                current->next = newNode;
            }
        }
        return in;
    }



    friend ostream& operator<<(ostream& out, const LinkedList<T>& l) {
        int i = 1;
        Node* current = l.Head;
        while (current != nullptr) {
            out << i << ": " << current->data << "  ";
            current = current->next;
            i++;
        }
        return out;
    }
    LinkedList& operator=(LinkedList& l) {
        Node* current = l.Head;
        Clear();
        while (current != nullptr) {

            this->push(current->data);
            current = current->next;
        }
        return *this;
    }

    T& operator[] (int i) {
        Node* current = Head;
        while (i > 0) {
            current = current->next;
            i--;
        }
        return current->data;
    }


};

int main() {
    setlocale(LC_ALL, "rus");
    LinkedList<string> list;
    list.push("10.5asdd");
    list.push("15.5asdasd");
    list.push("20.5adsad");
    list.push("25.5asdasd");
    list.push("30.5asdasd");


    LinkedList<string> listest;
    listest.push("likjsdfgdkiuhg");
    listest = list;
    cout << listest;
    cout << list[2];
}
