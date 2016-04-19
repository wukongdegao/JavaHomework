package homework3.pimCollection;


/*
 * @author Ԭ�� 13130110031
 */


public abstract class PIMEntity 
{
	//�¼����ȼ�
	String Priority; 

    // Ĭ�����ȼ�Ϊnormal
    PIMEntity() {
        Priority = "normal";
    }

    // �������ָ�����ȼ�
    PIMEntity(String priority) {
        Priority =  priority;
    }

    // �õ����ȼ�
    public String getPriority() {
        return Priority;
    }
    // �ı����ȼ�
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

//��������ӿ�
/* interface pimDate
{
	String datePrint(Calendar d);
}
*/