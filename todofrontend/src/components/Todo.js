import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container } from '@mui/system';
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';

export default function Todo() {
    const paperStyle = {padding:'50px 20px', width:600, margin:'20px auto'}
    const [taskName, setTaskName]=useState('')
    const [dueDate, setDueDate]=useState('')
    const [tasks, setTasks]=useState([])
    
    const handleClick=(e)=> {
        e.preventDefault()
        const task = {id, taskName, dueDate}
        const url = 'http://localhost:8080/todo/create';
        fetch(url, {
          method: "POST",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(task)
        }).then(() => {console.log("Sent to database!")})

        window.location.reload();
    }

    const handleDelete=(id)=> {
      const deleteURL = 'http://localhost:8080/todo/delete/' + id
      const deleteTask = {id, taskName, dueDate, completed}

    }

    useEffect(() => {
      const getAllUrl = 'http://localhost:8080/todo/getAll'
      fetch(getAllUrl)
      .then(res => res.json())
      .then((data) => {
        setTasks(data);
      }
    )
    }, [])

  return (
    <Container>
      <Paper elevation={2} style={paperStyle} >
        <h2 style = {{color:"Blue"}}> Add a Task </h2>
        <Box
          component="form"
          sx={{
            '& > :not(style)': { m: 1, width: '25ch' },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField id="standard-basic" label="Task" variant="outlined" 
          value={taskName}
          onChange={(e) => setTaskName(e.target.value)}
          />
          <TextField id="standard-basic" label="Due Date" variant="outlined"
          value={dueDate}
          onChange={(e) => setDueDate(e.target.value)}
          />
          <Button variant="contained" color="primary" onClick={handleClick}>
            Submit
          </Button>
        </Box>
      </Paper>
        <h2> Todo List </h2>
      <Paper elevation={3} style={paperStyle}>

          {tasks.map(task => (
            <Paper elevation={6} style={{margin: '10px', padding:'15px', textAlign:"left"}} key={task.id}>
              {task.taskName}
              <br></br>
              {task.dueDate}
              <Button variant="contained" color="error" size="small" style ={{float: 'right'}} disableElevation onClick={() => handleDelete(task.id)}> Delete</Button>
            </Paper>
          ))}
      </Paper>
    </Container>
  );
}
