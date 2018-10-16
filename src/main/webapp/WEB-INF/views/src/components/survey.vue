<template>
    <div>
        <span id ="graph-wrap">
            <canvas id="line-chart" width="700px" height="400px">
            </canvas>
        </span>
    </div>
</template>
<script>
import 'graph.js';
export default {
    data(){
        return {
            question: {
                title: 'Grade in School',
                options: ['A','B'],
                answers: [20,25]
            }
        }
    },
    mounted(){
        this.lineGraph();
    },
    methods: {
         lineGraph() {
                
                document.getElementById('line-chart').remove()
                document.getElementById('graph-wrap').innerHTML=`<canvas id="line-chart" width="700px" height="400px"></canvas>`
                
                let lineChart = document.getElementById('line-chart').getContext("2d");
                Chart.defaults.global.animation.duration = 300
                new Chart(lineChart, {
                    type: 'line',
                    data: {
                    labels: this.question.map(x => x.options),
                    datasets: [{
                        label: "Close",
                        fill: true,
                        borderColor: '#edad29',
                        borderWidth: 1,
                        pointRadius: 1,
                        backgroundColor: 'rgba(237, 128, 41, 0.2)',
                        data: this.question.map(x => x.answers),
                }]
                },
                options: {
                    legend: {
                    display: false
                }
            }
        });
    }
    }
}
</script>
<style lang="scss" scoped>

</style>
