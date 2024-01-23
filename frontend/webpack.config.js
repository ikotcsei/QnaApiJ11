const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
  entry: './index.js', // Entry point of your application
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js', // Output bundle file name
//    sourceMapFilename: "[name].js.map", // ????
  },
  devtool: "source-map",   //what is this line doing ?
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader', // Use Babel for .js and .jsx files
        },
      },
      {
              test: /\.css$/,
              use: [
                'style-loader',
                'css-loader'
              ]
            }
    ],
  },
  plugins: [
    new HtmlWebpackPlugin({
        //https://webpack.js.org/plugins/html-webpack-plugin/
      template: './index.html', // Use this HTML file as a template
    }),
  ],
};