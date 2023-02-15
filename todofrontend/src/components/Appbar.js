import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

export default function Appbar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="sticky" color="secondary">
      <Toolbar variant="dense" style={{ display: 'flex', justifyContent: 'center' }}>
          <Typography variant="h6" color="" component="div">
            Todo List
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
