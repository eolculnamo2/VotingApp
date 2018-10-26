<template>
    <div class="main-form-wrap">
        <form class="form-wrap" action="/create-new-chart" type="get">
            <div class="top-form">
                <div>
                    <h1>Question</h1>
                    <input class="question-input" v-model="question" type="text" />
                </div>
                <div>
                    <h2>Creator</h2>
                    <input v-model="creator" type="text" />
                </div>
            </div>
            <hr>
            <button type="button"
                    @click="addOption()"
                    v-if="options.length === 0"
                    class="button button--green">
                New Option
            </button>
            <div :key="'option'+i"
                 v-for="(x,i) in options"
                 class="options-wrap">
                 <h2>Option:</h2> 
                 <span @click="changeName(i)">{{x.name}}</span>
                <button type="button"
                        @click="addOption()"
                        v-if="i===0"
                        class="button button--green">
                    New Option
                </button>
                <button type="button"
                        @click="removeOption(i)"
                        class="button button--delete">
                    Delete
                </button>
            </div>
        </form>
         <button class="button button--green button--submit"
                 @click="createChart()"
                 type="button">Create Survey</button>
    </div>
</template>
<script>
import { Option } from '../scripts/general-functions';
export default {
    data() {
        return {
            question: '',
            creator: '',
            options: []
        }
    },
    created() {
        this.options.push(new Option("Example", 0));
    },
    methods: {
        addOption() {
            this.options.push(new Option("New Option", 0))
        },
        removeOption(i) {
            this.options.splice(i,1);
        },
        changeName(i){
            let arr = this.options.slice(0);
            let newName = prompt("Enter the new name of this option")
            arr[i].name = newName.trim();
            if(arr[i].name.length > 0){
                this.options = arr;
            }
        },
        createChart(){
            let payload = {
                    question: this.question,
                    options: this.options,
                    creator: this.creator
                }

            //payload[global._csrf_param_name] = global._csrf_token;

            fetch('/create-new-chart',{
            method: "POST",
            body: JSON.stringify(payload),
            headers: { "Content-Type": "application/json" }
            })
        }
    }
    //add get request with stringified JSON to store in BE.
}
</script>
<style lang="scss" scoped>
hr {
    margin: 2em 0;
}

.top-form {
    display: flex;
    align-items: flex-end;
    flex-wrap: wrap;

    div:first-child {
        margin-right: 1em;
    }
}

.main-form-wrap {
    margin: 5em;
}

.options-wrap {
    display: flex;
    align-items: flex-end;
    flex-wrap: wrap;

    h2 {
        margin: 0;
        margin-right: .5em;
    }
    span {
        font-size: 20px;
        margin-right: 1em;
        min-width: 100px;
        text-decoration: underline;
        cursor: pointer;
    }
    input {
        margin-right: 1em;
    }
    button {
        margin-right: .5em;
    }
}

.button {
    margin-top: 1em;
    padding: .5em 1em;
    border-radius: 3px;
    font-size: 12px;
    border: 0;

    &--green {
        background-color: #90ed93;
    }
    
    &--submit {
        margin-top: 5em;
        width: 150px;
    }

    &--delete {
        background-color: #ed9090;
    }
}

.question-input {
    width: 200px;
}

</style>
