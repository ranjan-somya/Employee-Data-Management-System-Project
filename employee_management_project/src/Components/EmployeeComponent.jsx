import React, { useEffect, useState } from 'react'
import { createEmployee, getEmployeeD, updateEmployee } from '../api/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {

    const [employeename,setEmployeename]=useState("");
    const [dept,setDept]=useState("");
    const [email,setEmail]=useState("");
    const [salary,setSalary]=useState("");
    const {id}=useParams();

    const[errors,setErrors]=useState({
        employeename:"",
        dept:"",
        email:"",
        salary:""
    })

    const navigator=useNavigate();

    
     const getAllEmployeeData=async(id)=>{
        try {
            
            const res=await getEmployeeD(id);
             setEmployeename(res.data.data.employeename);
             setDept(res.data.data.dept);
             setEmail(res.data.data.email);
             setSalary(String(res.data.data.salary));
        } catch (error) {
            console.log(error);
            
        }
     }

    useEffect(()=>{
        if (id) {
            getAllEmployeeData(id);
        }
    },[id])

    const addEmployee=async(employee)=>{
        try {
            
            const res=await createEmployee(employee);
            navigator("/employees")
        } catch (error) {
            console.log(error);
            
        }
    }

    const updateEmployeeData=async(id,employee)=>{
        try {
            
            const res=await updateEmployee(id,employee);
            navigator('/employees')
        } catch (error) {
            console.log(error);
            
        }
    }

    function SaveOrUpdateEmployee(e){
        e.preventDefault();
        if (validateForm()) {
            const employee={employeename,dept,email,salary};
            console.log(employee);
            if (id) {
                updateEmployeeData(id,employee);
            }else{

                addEmployee(employee);
            }
        }

    }

    function validateForm(){
        let valid=true;
        const errorCopy={... errors};

        if (employeename.trim()) {
            errorCopy.employeename='';
        }else{
            errorCopy.employeename="employee name is required"
            valid=false;
        }

        if (email.trim()) {
            errorCopy.email="";
        }else{
            errorCopy.email="Email is required"
            valid=false;
        }

        if (dept.trim()) {
            errorCopy.dept="";
        } else {
            errorCopy.dept="department feild is required";
            valid=false;
        }

        if (salary.trim()) {
            errorCopy.salary="";
        } else {
            errorCopy.salary="salary feild is required"
            valid=false;
        }

        setErrors(errorCopy);

        return valid;
    }

    function pageTitle(){
        if (id) {
            return <h2 className='text-center emp-form-title'>Update Employee</h2>
        }else{
            return <h2 className='text-center emp-form-title'>Add Employee</h2>
        }
    }
    function backToPage(){
        navigator("/employees");
    }

  return (
    <div className='container emp-form-page'>
        <button className="btn btn-primary btn-sm" onClick={backToPage}>
  ← Back
</button>
        <div className='row mt-5'>
        <div className='card col-md-6 offset-md-3 offset-md-3 emp-form-card'>
            {pageTitle()}
            <div className="card-body emp-form-body">
                <form action="">
                    <div className="form-group mb-2">
                        <label className='form-label'>First Name</label>
                        <input 
                                type="text"
                                placeholder='enter the name'
                                name='employeename'
                                value={employeename}
                                className={`form-control ${errors.employeename ? 'is-invalid':''}`}
                                onChange={(e)=>setEmployeename(e.target.value)}
                        />
                        {errors.employeename && <div className='invalid-feedback'>{errors.employeename}</div>}
                    </div>
                    <div className="form-group mb-2">
                        <label className='form-label'>Department :</label>
                        <input 
                                type="text"
                                placeholder='enter the dept'
                                name='dept'
                                value={dept}
                                className={`form-control ${errors.dept ? 'is-invalid':''}`}
                                onChange={(e)=>setDept(e.target.value)}
                        />
                        {errors.dept && <div className='invalid-feedback'>{errors.dept}</div>}
                    </div>
                    <div className="form-group mb-2">
                        <label className='form-label'>Email :</label>
                        <input 
                                type="email"
                                placeholder='enter the email'
                                name='email'
                                value={email}
                                className={`form-control ${errors.email ? 'is-invalid':''}`}
                                onChange={(e)=>setEmail(e.target.value)}
                        />
                        {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                    </div>
                    <div className="form-group mb-2">
                        <label className='form-label'>Salary :</label>
                        <input 
                                type="number"
                                placeholder='enter the Salary'
                                name='salary'
                                value={salary}
                              className={`form-control ${errors.salary ? 'is-invalid':''}`}
                                onChange={(e)=>setSalary(e.target.value)}
                        />
                        {errors.salary && <div className='invalid-feedback'>{errors.salary}</div>}
                    </div>
                    <button className='btn btn-success emp-submit-btn' onClick={SaveOrUpdateEmployee}>Submit</button>
                </form>
            </div>
        </div>
        </div>
    </div>
  )
}

export default EmployeeComponent