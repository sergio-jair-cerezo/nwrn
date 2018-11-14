import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';

export default class HighScoresScreen extends React.Component {

  static navigationOptions = {
    title: 'High Scores Screen',
  };

  render() {
    console.log('this.props in HighScoresScreen', this.props);
    var contents = this.props.screenProps['scores'].map((score) => (
      <Text key={score.name}>
        {score.name}:{score.value}
        {'\n'}
      </Text>
    ));
    return (
      <View style={styles.container}>
        <Text style={styles.highScoresTitle}>High Scores:</Text>
        <Text style={styles.scores}>{contents}</Text>
        <Text style={styles.highScoresTitle}>(React Native Screen Made)</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#FFFFFF',
  },
  highScoresTitle: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  scores: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});