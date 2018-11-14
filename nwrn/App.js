/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React from 'react';
import { createStackNavigator } from 'react-navigation';

import HelloWorldScreen from './screens/HelloWorldScreen';
import SecondScreen from './screens/SecondScreen';
import HighScoresScreen from './screens/HighScoresScreen';

const AppNavigator = createStackNavigator({
  HelloWorld: { screen: HelloWorldScreen },
  SecondScreen: { screen: SecondScreen }
});

const HighScoresNavigator = createStackNavigator({
  HighScoresScreen: { screen: HighScoresScreen }
});

class App extends React.Component {
  render() {
    console.log('this.props in App', this.props); // This will list the initialProps.

    // StackNavigator **only** accepts a screenProps prop so we're passing
    // initialProps through that.
    if (this.props.scores) {
      return <HighScoresNavigator screenProps={this.props} />; 
    }
    return <AppNavigator screenProps={this.props} />; 
  }
}

export default App;
