import Home from './components/home.vue';
import Survey from './components/survey.vue';
import NewChart from './components/new-chart.vue';

export default [
    {path: '/', component: Home},
    {path: '/survey/:id', component: Survey},
    {path: '/new-chart', component: NewChart}
]