/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    static Map<Integer, Employee> map = new HashMap<Integer, Employee>();
    
    public int getImportance(List<Employee> employees, int id) {
        //Map<Integer, Employee> map = new HashMap<Integer, Employee>(); // ~ 2000
        
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        
        return sum(map.get(id));
    }
    
    
    private int sum(Employee employee) {
        if (employee == null) {
            return 0;
        }
        
        int ret = employee.importance;
        
        if (employee.subordinates != null && employee.subordinates.size() > 0) {
            for (Integer id : employee.subordinates) {
                ret += sum(map.get(id));
            }

        }
        
        return ret;
    }
}