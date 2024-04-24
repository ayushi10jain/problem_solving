package MeetingScheduler;

public class Slot {
        int sTime;
        int endTime;
        public Slot(int sTime, int endTime){
            this.sTime = sTime;
            this.endTime = endTime;
        }

    @Override
    public int hashCode()
    {

        return this.sTime;
    }

    @Override
    public boolean equals(Object obj)
    {

        // if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Slot slot = (Slot) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (slot.sTime == this.sTime);
    }

}
