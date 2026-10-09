import React, { useEffect, useState } from 'react'
import { listEmployees } from '../api/EmployeeService';
import { useNavigate } from 'react-router-dom';
import { deleteEmployee } from '../api/EmployeeService';

const ListEmployeeComponents = () => {
    const navigator=useNavigate();
//    const dummyData = [
//   {
//     id: 1,
//     employeename: "Somya",
//     dept: "IT",
//     salary: 23000.00,
//     email: "ranansomya9938@gmail.com"
//   },
//   {
//     id: 2,
//     employeename: "Rahul",
//     dept: "HR",
//     salary: 30000.00,
//     email: "rahul@gmail.com"
//   },
//   {
//     id: 3,
//     employeename: "Priya",
//     dept: "Finance",
//     salary: 35000.00,
//     email: "priya@gmail.com"
//   }
// ];

    const [employees,setEmployees]=useState([]);

    const getAllData=async()=>{
        const res=await listEmployees();
        setEmployees(res.data.data);
    }

    useEffect(()=>{
        getAllData();
        // e.preventDefault();
        // listEmployees().then((response)=>{
        //     setEmployees(response.data.data)
        // }).catch(error=>{
        //     console.log(error);
            
        // })
    },[])

    function addNameEmployee(){
        navigator('/add-employee')
    }
    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }
    
    function deleteEmployeeData(id){
        deleteEmployee(id).then((res)=>{
            getAllData();
        }).catch((error)=>{
            console.log(error);
            
        })
        
    }
  return (
    <div className='container emp-container'>

    <h1 className='text-center emp-title'>List of Employee</h1>

    <button type="button" className="btn btn-primary emp-add-btn" onClick={addNameEmployee}>Add Employee</button>
    <table className='table table-striped table-bordered emp-table'>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Employee Dept</th>
                <th>Employee Salary</th>
                <th>Employee Email</th>
                <th className='text-center'>Actions</th>
                
            </tr>
        </thead>
        <tbody>
            {
                employees.map((employee)=>
                <tr key={employee.id}>
                    <td>{employee.id}</td>
                    <td>{employee.employeename}</td>
                    <td>{employee.dept}</td>
                    <td>{employee.salary}</td>
                    <td>{employee.email}</td>
                    <td className='emp-actions'>
                        <button className='btn btn-info emp-btn-update' onClick={()=>updateEmployee(employee.id)}>Update</button>
                        <button className='btn btn-danger emp-btn-delete' onClick={()=>deleteEmployeeData(employee.id)}>Delete</button>
                    </td>
                    
                </tr>
                )
            }
        </tbody>
    </table>
    </div>
  )
}

export default ListEmployeeComponents