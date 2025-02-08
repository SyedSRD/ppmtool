import React, { Component } from 'react'
import ProjectItem from './project/ProjectItem';

 class Dashboard extends Component {
  render() {
    return (<div>
        <h1 className='alert alert-warning'>Dashboard </h1>
        <ProjectItem />
        <ProjectItem />
        <ProjectItem />
        
        </div>
    )
  }
}
export default Dashboard;

