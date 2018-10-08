var path = require('path');
const CleanWebpackPlugin = require('clean-webpack-plugin');
module.exports = {
    entry: './src/main.js',
    output: {
        path: path.resolve('./bundle'),
        filename: 'bundle.js'
    },
    //watch: true,
    optimization: {
        splitChunks: {
            chunks: 'all'
        }
    },
    plugins: [
              new CleanWebpackPlugin(['assets/dist']),
            ],
    devServer: {
        compress: true,
        port: 3000,
        proxy: {
            '/': 'http://127.0.0.1:8080/'
          }
      },
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