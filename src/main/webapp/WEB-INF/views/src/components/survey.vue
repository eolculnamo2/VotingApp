<template>
    <div>
        <div class="options" v-if="notVoted">
            <div class="option" :key="'option'+i" v-for="(x,i) in chartInfo.option">
                <h4>
                    {{x.name}}
                </h4>
                <button @click="submitVote(i)">
                    Vote
                </button>
            </div>
        </div>
        <p class="thank-you-for-voting" v-else>
            Thank you for voting!
        </p>
        <canvas id="canvas-chart" width="400px" height="300px"></canvas>
    </div>
    
</template>
<script>
import Chart from 'chart.js'
export default {
    data() {
        return {
            chartInfo: {},
            notVoted: true
        }
    },
    mounted() {
        Chart.defaults.global.defaultFontSize= 35;
        fetch('/get-chart?id='+this.$route.params.id)
        .then(res => res.json() )
        .then(data =>{
            this.chartInfo = data[0];
            this.chartInfo.option =JSON.parse(this.chartInfo.option);
            this.renderChart();  
        });
    },
    methods: {
        submitVote(i){
            this.notVoted = false;
            this.chartInfo.option[i].value++;
           
            let payload = {
                question: this.chartInfo.question,
                option: JSON.stringify(this.chartInfo.option),
                creator: this.chartInfo.creator,
                id: this.chartInfo.id
            }

            fetch('/submit-vote',{
            method: "POST",
            body: JSON.stringify(payload),
            headers: { "Content-Type": "application/json" }
            })

            this.renderChart();
            //Chart.update();
            
        },
        renderChart() {
            new Chart(document.getElementById("canvas-chart"), {
                type: 'bar',
                data: {
                labels: this.chartInfo.option.map( x => x.name),
                datasets: [
                    {
                    label: this.chartInfo.option.map( x => x.name),
                    backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
                    data: this.chartInfo.option.map( x => x.value )
                    }
                ]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    },
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
.options {
    display: flex;
    align-items: center;
    flex-direction: column;
}

.option {
    display: flex;
    justify-content: space-between;
    align-items: center;
    h4 {
        margin-right: 1em;
    }

    button {
        background-color: #90ed93;
        border: 0;
        padding: .5em 2em;
        border-radius: 3px;
        cursor: pointer;

        &:hover {
            opacity: .8;
        }
    }
}

.thank-you-for-voting{
    display: flex;
    justify-content: center;
}

#canvas-chart{
    margin: auto;
    height: 400px !important;
    width: 500px !important;
}

</style>
