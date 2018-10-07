var path = require('path')
module.exports = {
    entry: './components/main.js',
    output: {
        path: path.resolve('./bundle'),
        filename: 'bundle.js'
    },
    devServer: {
        //contentBase: path.join(__dirname, 'public'),
        compress: true,
        port: 9000,
        proxy: {
            '/': 'http://127.0.0.1:8080/picture-dashboard/'
          }
      },
    //watch: true,
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                loader: 'babel-loader',
                query: {
                    presets: ['env']
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
              },
            {
                test: /\.scss$/,
                loader: 'style-loader!css-loader!sass-loader!'
            }
        ]
    }
}