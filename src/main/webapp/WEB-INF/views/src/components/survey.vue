<template>
    <div>
        <canvas id="canvas-chart" width="400px" height="300px"></canvas>
    </div>
    
</template>
<script>
import Chart from 'chart.js'
export default {
    data() {
        return {
            chartInfo: {
                question: "Sample",
                options: ["A","B"],
                creator: "Joe"
            }
        }
    },
    mounted() {
        Chart.defaults.global.defaultFontSize= 35;
        this.renderChart();  
    },
    methods: {
        renderChart() {
            new Chart(document.getElementById("canvas-chart"), {
                type: 'bar',
                data: {
                labels: this.chartInfo.options.map( x => x),
                datasets: [
                    {
                    label: "Population (millions)",
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                    data: [2478,5267,734,784,433]
                    }
                ]
                },
                options: {
                    legend: { display: false },
                    title: {
                        display: true,
                        text: this.chartInfo.question
                        }
                }
            });
        }
    }
}
</script>
<style lang="scss" scoped>
#canvas-chart{
    margin: auto;
    height: 400px !important;
    width: 500px !important;
}

</style>
