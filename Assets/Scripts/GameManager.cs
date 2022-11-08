using UnityEngine;
using UnityEngine.SceneManagement;
using System.Linq;

public class GameManager : MonoBehaviour
{
    public GameObject[] players;

    public void CheckWinState()
    {
        int aliveCount = 0;

        foreach (GameObject player in players)
        {
            if (player.activeSelf) {
                aliveCount++;
            }
        }

        if (aliveCount <= 1) {
            Invoke(nameof(NewRound), 3f);
        }
    }

    public bool IsAPlayerDead()
    {
        return players.Any(x => x.GetComponent<MovementController>().IsDead);
    }

    public void FreezePlayers()
    {
        foreach(GameObject player in players)
        {
            player.GetComponent<MovementController>().enabled = false;
            player.GetComponent<BombController>().enabled = false;
        }
    }

    private void NewRound()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }
}
