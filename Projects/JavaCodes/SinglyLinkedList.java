// Singly Linked List Implementation
class node
{
    public int data;
    public node next;

   
    public node(int no)
    {
        this.data = no;
        this.next = null;
    }
}
class SinglyLL
{
    public node first;
    public int iCount;

    public SinglyLL()
    {
        System.out.println("Object of SLL gets created");
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int no)
    {
        node newn = null;
        //change code 
        newn = new node(no);
       

        newn.next = this.first;
        this.first = newn;

        this.iCount++;
    }
    public void Insertlast(int no)
    {
        node newn = null;
       
        newn = new node(no);
        node temp = null;
        if(this.first == null)
        {
            this.first = newn;
        }
        else 
        {
            temp = this.first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newn;
        }
        this.iCount++;
    }
    

    public void DeleteFirst()
    {
        if(this.first == null)
        {
            return;
        }
        else if(this.first.next == null)
        {
            this.first = null;
            System.gc();
        }
        else
        {
            this.first = this.first.next;
        }
        System.gc();
        this.iCount--;
    }
    public void DeleteLast()
    {
        if(this.first == null)
        {
            return;
        }
        else if(this.first.next == null)
        {
            this.first = null;
            System.gc();
        }
        else
        {
            node temp = null;
            temp = this.first;
            while (temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        System.gc();
        this.iCount--;
    }
    public void InsertAtPos(int no,int pos)
    {
        node newn = null;
        node temp = null;
        int iCnt = 0;
        if((pos < 1) || (pos > this.iCount+1))
        {
            System.out.println("Invalid position");
            return;
        }

        if(pos == 1)
        {
            this.InsertFirst(no);
        }
        else if(pos == iCount+1)
        {
            this.Insertlast(no);
        }
        else
        {
            newn = new node(no);
            temp = this.first;
            for(iCnt = 1;iCnt < pos-1;iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
            this.iCount++;
        }
    }
    public void DeleteAtPos(int pos)
    {
        node temp = null;
        int iCnt = 0;
        if((pos < 1) || (pos > this.iCount))
        {
            System.out.println("Invalid position");
            return;
        }

        if(pos == 1)
        {
            this.DeleteFirst();
        }
        else if(pos == iCount)
        {
            this.DeleteLast();
        }
        else
        {
            temp = this.first;
            for(iCnt = 1;iCnt < pos-1;iCnt++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            System.gc();
            this.iCount--;

        }
    }

    public void Display()
    {
        node temp = null;
        temp = this.first;
        
        while (temp != null)
        {
            System.out.print("| "+temp.data+" | ->");
            temp = temp.next;
           
        }
        System.err.println("null");
    }
    public int Count()
    {
        return this.iCount;
    }

}
public class SinglyLinkedList {
    public static void main(String A[])
    {
        SinglyLL obj = null;
        int iRet = 0;

        obj = new SinglyLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        obj.Insertlast(101);
        obj.Insertlast(111);
        obj.Insertlast(121);
        
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteFirst();
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteLast();
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        obj.InsertAtPos(105,4);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        obj.DeleteAtPos(4);
        obj.Display();
        iRet = obj.Count();
        System.out.println("Number of nodes are : "+iRet);

        //Important for memory deallocation
        obj = null;
        System.gc();

    }
}
