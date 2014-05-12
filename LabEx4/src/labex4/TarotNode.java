package labex4;

public class TarotNode 
{
    
    Card c;
    TarotNode next;
    
    Card getData()
    {
        return c;
    }
    TarotNode getNext()
    {
        return next;
    }
    void setData(Card c1)
    {
        c = c1;
    }
    void setNext(TarotNode n)
    {
        next = n;
    }

}
