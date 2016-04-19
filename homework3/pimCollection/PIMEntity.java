package homework3.pimCollection;


/*
 * @author 袁点 13130110031
 */


public abstract class PIMEntity 
{
	//事件优先级
	String Priority; 

    // 默认优先级为normal
    PIMEntity() {
        Priority = "normal";
    }

    // 构造具有指定优先级
    PIMEntity(String priority) {
        Priority =  priority;
    }

    // 得到优先级
    public String getPriority() {
        return Priority;
    }
    // 改变优先级
    public void setPriority(String p) {
        Priority = p;
    }
    

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    abstract public void fromString(String s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();
}

//日期输出接口
/* interface pimDate
{
	String datePrint(Calendar d);
}
*/