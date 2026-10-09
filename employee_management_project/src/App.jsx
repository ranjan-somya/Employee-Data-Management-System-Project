import React from 'react'
import ListEmployeeComponents from './Components/ListEmployeeComponents'
import Header from './Components/Header'
import Footer from './Components/Footer'
import {BrowserRouter,Routes,Route} from "react-router-dom"
import EmployeeComponent from './Components/EmployeeComponent'

const App = () => {
  return (
    <>
    <BrowserRouter>
    <Header/>
    <Routes>
      {/* http://localhost:3000/ */}
      <Route path='/' element={<ListEmployeeComponents/>}>
      </Route>

      {/* http://localhost:3000/employees */}
      <Route path='/employees' element={<ListEmployeeComponents/>}></Route>

      <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
      <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
    </Routes>
    <Footer/>
    </BrowserRouter>
    </>

  )
}

export default App